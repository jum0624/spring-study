package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        //default 일 경우 ComponentScan이 있는 hello.core 패키지 전체를 다 찾음
//        basePackages = "hello.core.member", // 해당 패키지 기준 하위 내용만 찾아냄
//        basePackageClasses = AutoAppConfig.class,  // 해당 클래스가 있는 패키지를 찾음
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)  // Configuration 에노테이션 클래스는 제외
)
public class AutoAppConfig {

}
