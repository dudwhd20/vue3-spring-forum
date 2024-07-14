package com.youngjong.forum.core.response.advice;


import com.youngjong.forum.core.config.IgnoreResponseAdvice;
import com.youngjong.forum.core.response.ApiResponses;
import com.youngjong.forum.core.response.ErrorResponses;
import lombok.extern.slf4j.Slf4j;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.LinkedHashSet;
import java.util.Set;


@Slf4j
@RestControllerAdvice(basePackages = "com.youngjong.forum")
public class ApiResponsesAdvice implements ResponseBodyAdvice<Object> {
    private final Set<Object> excludeClassList;

    private ApiResponsesAdvice() {
        this.excludeClassList = new LinkedHashSet<>();

        Reflections reflections = new Reflections(new ConfigurationBuilder()
                .setUrls(ClasspathHelper.forPackage("com.youngjong.forum"))
                .setScanners(new SubTypesScanner(), new TypeAnnotationsScanner()));

        Set<Class<?>> annotated = reflections.getTypesAnnotatedWith(IgnoreResponseAdvice.class);
        excludeClassList.addAll(annotated);
    }

    @Override
    public boolean supports(@NonNull MethodParameter returnType,
                            @NonNull Class converterType) {
        return excludeClassList.stream()
                .noneMatch(excludeClass -> excludeClass
                        .equals(returnType.getContainingClass()));
    }

    @Override
    public Object beforeBodyWrite(Object body,
                                  @NonNull MethodParameter returnType,
                                  @NonNull MediaType selectedContentType,
                                  @NonNull Class selectedConverterType,
                                  @NonNull ServerHttpRequest request,
                                  @NonNull ServerHttpResponse response) {

        if (body instanceof ErrorResponses errorResponses) {
            return ApiResponses.error("FAIL", errorResponses);
        }

        return ApiResponses.success("SUCCESS", body);

    }
}
