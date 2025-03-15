package com.atguigu.lease.web.admin.custom.converter;

import com.atguigu.lease.model.enums.BaseEnum;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;
import org.springframework.stereotype.Component;

@Component
public class StringToBaseEnumConverterFactory implements ConverterFactory<String, BaseEnum> {

    @Override
    public <T extends BaseEnum> Converter<String, T> getConverter(Class<T> targetType) {
        return new Converter<String, T>() {// 返回一个转换器
            @Override
            public T convert(String code) {
                T[] enumConstants = targetType.getEnumConstants();// 获取枚举类中的所有枚举值
                for (T enumConstant : enumConstants) {
                    if (enumConstant.getCode().equals(Integer.valueOf(code))) {// 如果枚举值中的code与传入的code相等，则返回该枚举值
                        return enumConstant;
                    }
                }
                throw new IllegalArgumentException("code" + code + "非法");
            }
        };

    }
}
