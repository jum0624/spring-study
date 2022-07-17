package hello.core.scan.filter;

import java.lang.annotation.*;

@Target(ElementType.TYPE)  // 중요.. 클래스 레벨이 붙는것
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyExcludeComponent {
}
