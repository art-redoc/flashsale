package redoc.sq.base.convertors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import redoc.sq.base.dto.ListResultDTO;
import redoc.sq.base.dto.PageResultDTO;
import redoc.sq.base.dto.ResultDTO;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Model
 */
public abstract class AbstractConvertor<Model, DTO> {

    public abstract Model toModel(final DTO dto);

    public DTO toDTO(final Model model) {
        return this.toDTO(model, false);
    }

    public abstract DTO toDTO(final Model model, boolean forListView);

    public final List<Model> toListModel(final List<DTO> dtoList) {
        final List<Model> modelList = dtoList.stream().map(dto -> this.toModel(dto)).collect(Collectors.toList());
        return modelList;
    }

    public final List<DTO> toListDTO(final List<Model> modelList) {
        final List<DTO> dtoList = modelList.stream().map(model -> this.toDTO(model, true)).collect(Collectors.toList());
        return dtoList;
    }

    public final List<DTO> toListDTO(List<Model> modelList, boolean forListView) {
        final List<DTO> dtoList = modelList.stream().map(model -> this.toDTO(model, forListView)).collect(Collectors.toList());
        return dtoList;
    }

    public final Page<DTO> toPageDTO(final Page<Model> modelPage) {
        final List<Model> modelList = modelPage.getContent();
        final List<DTO> dtoList = this.toListDTO(modelList);
        final long totalElements = modelPage.getTotalElements();
        final Page<DTO> dtoPage = new PageImpl<>(dtoList, this.getPageable(modelPage), totalElements);
        return dtoPage;
    }

    public final Page<DTO> toPageDTO(final Page<Model> modelPage, boolean forListView) {
        final List<Model> modelList = modelPage.getContent();
        final List<DTO> dtoList = this.toListDTO(modelList, forListView);
        final long totalElements = modelPage.getTotalElements();
        final Page<DTO> dtoPage = new PageImpl<>(dtoList, this.getPageable(modelPage), totalElements);
        return dtoPage;
    }

    public final ResultDTO<DTO> toResultDTO(final Model model) {
        final DTO dto = (model == null) ? null : this.toDTO(model);
        final ResultDTO<DTO> resultDTO = ResultDTO.success(dto);
        return resultDTO;
    }

    public final ResultDTO<DTO> toResultDTO(final Model model, boolean forListView) {
        final DTO dto = (model == null) ? null : this.toDTO(model, forListView);
        final ResultDTO<DTO> resultDTO = ResultDTO.success(dto);
        return resultDTO;
    }

    public final ListResultDTO<DTO> toResultDTO(final List<Model> modelList) {
        final List<DTO> dtoList = this.toListDTO(modelList);
        final ListResultDTO<DTO> resultDTO = ListResultDTO.success(dtoList);
        return resultDTO;
    }

    public final ListResultDTO<DTO> toResultDTO(final List<Model> modelList, boolean forListView) {
        final List<DTO> dtoList = this.toListDTO(modelList, forListView);
        final ListResultDTO<DTO> resultDTO = ListResultDTO.success(dtoList);
        return resultDTO;
    }

    public final PageResultDTO<DTO> toResultDTO(final Page<Model> modelPage) {
        final List<DTO> dtoList = this.toListDTO(modelPage.getContent());
        final PageResultDTO<DTO> resultDTO = PageResultDTO.success(dtoList, modelPage);
        return resultDTO;
    }

    public final PageResultDTO<DTO> toResultDTO(final Page<Model> modelPage, boolean forListView) {
        final List<DTO> dtoList = this.toListDTO(modelPage.getContent(), forListView);
        final PageResultDTO<DTO> resultDTO = PageResultDTO.success(dtoList, modelPage);
        return resultDTO;
    }

    public Pageable getPageable(final Page<Model> modelPage) {
        try {
            final Field pageableField = PageImpl.class.getSuperclass().getDeclaredField("pageable");
            pageableField.setAccessible(true);
            return (Pageable) pageableField.get(modelPage);
        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
        }
        return null;
    }
}
