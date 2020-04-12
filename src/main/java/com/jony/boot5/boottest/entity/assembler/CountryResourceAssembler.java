package com.jony.boot5.boottest.entity.assembler;

import com.jony.boot5.boottest.controller.RestfulController;
import com.jony.boot5.boottest.entity.Country;
import com.jony.boot5.boottest.entity.CountryResource;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;

/**
 * 资源装配器
 */
public class CountryResourceAssembler extends RepresentationModelAssemblerSupport<Country, CountryResource> {

    /**
     * Creates a new {@link RepresentationModelAssemblerSupport} using the given controller class and resource type.
     *
     * @param controllerClass must not be {@literal null}.
     * @param resourceType    must not be {@literal null}.
     */
    public CountryResourceAssembler(Class<?> controllerClass, Class<CountryResource> resourceType) {
        super(controllerClass, resourceType);
    }

    public CountryResourceAssembler() {
        super(RestfulController.class,CountryResource.class);
    }

    @Override
    /**
     * 重写的实例model 方法在生成resource的时候调用
     * 等于一个转换器，把原始的资源转换为resource对象
     */
    protected CountryResource instantiateModel(Country entity) {
        return new CountryResource(entity);
    }

    @Override
    /**
     * 创建资源链接的方法
     * 此方法调用createModelWithId,并指定资源标识符与所属实体
     */
    public CountryResource toModel(Country entity) {
        return createModelWithId(entity.getId(),entity);
    }
}
