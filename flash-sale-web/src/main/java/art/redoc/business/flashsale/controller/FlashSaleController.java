package art.redoc.business.flashsale.controller;

import art.redoc.base.conts.BusinessConstants;
import art.redoc.base.model.MessageModel;
import art.redoc.business.flashsale.service.FlashSaleService;
import art.redoc.dto.goods.dto.FlashSalePlanDTO;
import art.redoc.business.goods.model.FlashSalePlan;
import art.redoc.business.goods.model.RelationUserFlashSalePlan;
import art.redoc.business.goods.service.FlashSalePlanService;
import art.redoc.business.goods.service.RelationUserFlashSalePlanService;
import art.redoc.core.dto.ResultDTO;
import art.redoc.dto.goods.enums.FlashSaleStatusEnum;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * FlashSalePlan controller.
 *
 * @author code generator
 */
@Slf4j
@RestController
@RequestMapping("/api/flashSale")
public class FlashSaleController {

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private FlashSaleService flashSaleService;
    @Autowired
    private FlashSalePlanService flashSalePlanService;
    @Autowired
    private RelationUserFlashSalePlanService relationUserFlashSalePlanService;

    /**
     * Get model list.
     *
     * @return Model list.
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResultDTO<List<FlashSalePlanDTO>> search() {
        final Set<String> set = redisTemplate.opsForZSet().rangeByScore(BusinessConstants.FLASH_SALE_ZSET_KEY, 0,
                System.currentTimeMillis());
        // 这个地方可以不用反序列化在转化成对象，正式环境可以考虑设计一个字符串交给前端自行解析从而提高效率
        // 因为商品信息变化频率很低，而数量信息变化频率很高，所以将其分开存储，方便秒杀时对数量信息的修改
        // 商品信息几乎不会改变，所以可以考虑在redis之前再加一层local cache，通过一些约定来进一步的提高秒杀系统的吞吐量
        if(CollectionUtils.isEmpty(set)){
            return ResultDTO.success(Collections.EMPTY_LIST);
        }
        final List<FlashSalePlanDTO> result = set.stream().map(value -> {
            try {
                return objectMapper.readValue(value, FlashSalePlanDTO.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }).collect(Collectors.toList());
        final Map entries = redisTemplate.opsForHash().entries(BusinessConstants.FLASH_SALE_AMOUNT_HASH_KEY);
        if(CollectionUtils.isEmpty(entries)){
            return ResultDTO.success(Collections.EMPTY_LIST);
        }
        result.forEach(x -> {
            final Object object = entries.get(x.getId().toString());
            if(Objects.isNull(object)){
                x.setAmount(0);
                return;
            }
            x.setAmount(Integer.valueOf(object.toString()));
        });
        return ResultDTO.success(result);
    }

    /**
     * 开始秒杀。
     * v0.1 目前只实现了基础的秒杀功能，使用三个redis的数据结构，分别记录了1.秒杀详情 2.秒杀的触发时间 3.秒杀商品剩余数量。
     * 还未实现每个用户限定秒杀商品个数，这个功能应该需要将用户id和秒杀id存进redis，根据阈值来判断该用户是否可以参加该商品的秒杀，可能还需要加一个redis
     * 数据结构，记录该用户id是否有资格继续参加此秒杀，如果没有资格直接返回结果，提高效率。
     *
     * @param flashSalePlanDTO The model DTO.
     * @return DTO of the model that needs to be created.
     */
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResultDTO<MessageModel> startFlashSale(@RequestBody @Valid final FlashSalePlanDTO flashSalePlanDTO) throws JsonProcessingException {
        return flashSaleService.startFlashSale(flashSalePlanDTO);
    }

    /**
     * 获取结果
     *
     * @return
     */
    @RequestMapping(value = "/result", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResultDTO<FlashSaleResultEnum> getFlashSaleResult(Long flashSaleId, Long userId) {
        final FlashSalePlan flashSalePlan = flashSalePlanService.get(flashSaleId);
        if (flashSalePlan.getStatus().equals(FlashSaleStatusEnum.PENDING)) {
            return ResultDTO.success(FlashSaleResultEnum.PENDING);
        }
        List<RelationUserFlashSalePlan> relationUserFlashSalePlans = relationUserFlashSalePlanService.getByFlashSalePlanId(flashSaleId);
        for (RelationUserFlashSalePlan relationUserFlashSalePlan : relationUserFlashSalePlans) {
            if (relationUserFlashSalePlan.getUser().getId().equals(userId)) {
                return ResultDTO.success(FlashSaleResultEnum.SUCCESS);
            }
        }
        return ResultDTO.success(FlashSaleResultEnum.FAILURE);
    }

    private enum FlashSaleResultEnum {
        PENDING, SUCCESS, FAILURE
    }
}