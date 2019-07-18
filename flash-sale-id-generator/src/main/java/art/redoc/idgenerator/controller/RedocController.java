//package art.redoc.idgenerator.controller;
//
//import art.redoc.api.idgenerator.SnowFlakeGeneratorRequestMappingApi;
//import art.redoc.common.service.SnowFlakeGeneratorService;
//import art.redoc.core.dto.ResultDTO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class RedocController {
//
//    @Autowired
//    private SnowFlakeGeneratorService snowFlakeGeneratorService;
//
//    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResultDTO<Long> generator() throws Exception {
//        return ResultDTO.success(snowFlakeGeneratorService.generate());
//    }
//}
