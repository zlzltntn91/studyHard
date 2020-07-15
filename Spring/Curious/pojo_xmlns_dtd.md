# POJO

Plain Old Java Object
말 그대로 해석을 하면 오래된 방식의 간단한 자바 오브젝트

`우리는 사람들이 자기네 시스템에 보통의 객체를 사용하는 것을 왜 그렇게 반대하는지 궁금하였는데, 간단한 객체는 폼 나는 명칭이 없기 때문에 그랬던 것이라고 결론지었다. 그래서 적당한 이름을 하나 만들어 붙였더니, 아 글쎄, 다들 좋아하더라고. -마틴 파울러`

- POJO
  1. 클래스 상속을 강제하지 않는다.
  2. 인터페이스 구현을 강제하지 않는다.
  3. 어노테이션 사용을 강제하지 않는다.

POJO는 자바 언어 사양 외에 어떠한 제한에도 묶이지 않은 자바 오브젝트라고 할 수 있다. 이를테면 POJO는 다음을 따라야 할 필요는 없다.

- 미리 정의된 클래스의 확장.:
  ```java
  public class Foo extends javax.servlet.http.HttpServlet { ...
  ```
- 미리 정의된 인터페이스의 구현.:
  ```java
  public class Bar implements javax.ejb.EntityBean { ...
    ```
- 미리 정의된 애너테이션을 포함.
  ```java
  @javax.persistence.Entity public class Baz { ...
  ```

그러나 기술적 어려움이나 기타 이유로 인해 POJO 호환으로 기술하고 있는 수많은 소프트웨어 제품이나 프레임워크들은 실제로 정상 동작을 위해 퍼시스턴스(persistence)와 같은 기능을 위해 미리 정의된 애너테이션의 사용을 요구하고 있다.

# XMLNS

XML Namespace
element간 충돌을 방지해 주는 방법
element의 이름과 속성의 이름을 하나의 그룹으로 묶어 충돌을 해결

표준프레임워크의 context-aspect.xml을 살펴보자
```xml
<beans xmlns="http://www.springframework.org/schema/beans"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	        xmlns:aop="http://www.springframework.org/schema/aop"
	        xsi:schemaLocation="http://www.springframework.org/schema/beans
                                      http://www.springframework.org/schema/beans/spring-beans-4.0.xsd
                                      http://www.springframework.org/schema/aop
                                      http://www.springframework.org/schema/aop/spring-aop-4.0.xsd"
>
  <aop:aspectj-autoproxy/>
</bean>
```
 의존성 artifactId와 의존성버전의 경우 일반적으로  pom.xml에 정의된 버전을 그대로 기술하면 되는데
 소수점 2자리 버전까지만 명시해도 된다.
 예를들어 <spring.maven.artifact.version>4.2.4.RELEASE</spring.maven.artifact.version> 라면
 xsd 버전은 4.0으로 명시하면 된다.

# DTD

Document Type Difinition

XML 문서가 어떤 요소로 구성되어 있는지를 정의할 때에 사용
XML 은 자유롭게 태그를 정의하여 문서를 작성할 수 있지만, 어떤 태그를 사용할지 XML 문서의 구조를 결정해두면 유용하다.


# XSD

XML Schema Definition

XML 문서의 구조 및 해당 문서가 포함할 수 있는 적법한 요소와 속성을 명시한다.
XML 에서 스키마를 정의할 때는 XSD 뿐만 아니라 DTD 를 사용할 수 있다.
