## ⦿ 소프트웨어 모듈이 가져야 하는 세 가지 기능
1. 실행중에 제대로 동작하는 것이다. 이것은 모든 모듈의 존재 이유라고 할 수 있다.
2. 변경을 위해 존재하는 것이다. 대부분의 모듈은 생명주기 동안 변경되기 때문에 간단한 작업만으로도 변경이 가능해야 한다.
  변경하기 어려운 모듈은 제대로 동작하더라도 개선해야 한다.
3. 코드를 읽는 사람과 의사소통하는 것이다. 모듈은 특별한 훈련 없이도 개발자가 쉽게 읽고 이해할 수 있어야 한다. 읽는 사람과 의사소통할 수 없는 모듈은 개선해야 한다.

## ⦿ 설계원칙
1. 객체를 인터페이스와 구현으로 나누고 인터페이스만을 공개하는 것은 객체 사이의 결합도를 낮추고 변경하기 쉬운 코드를 작성하게 해준다.
2. 자기 자신의 문제를 스스로 해결하도록 해라. 데이터와 프로세스가 동일한 모듈 내부에 위치하도록 프로그래밍하는 방식을 **객체지향 프로그래맹**이라고 부른다.
3. 대상이 비록 실세계에서는 생명이 없는 수동적인 존재라고 하더라도 객체지향의 세계로 넘어오는 순간 그들은 생명과 지능을 가진 싱싱한 존재로 다시 태어난다.
4. 훌륭한 객체지향 설계란 협력하는 객체 사이의 의존성을 적절하게 관리하는 설계다. 세상에 엮인 것이 많은 사람일수록 변하기 어려운 것처럼 객체가 실행되는 주변
  환경에 강하게 결합될 수록 변경하기 어려워진다.
5. 어떤 클래스가 필요한지를 고민하기 전에 어떤 객체들이 필요한지 고민하라.
  객체를 독립적인 존재가 아니라 기능을 구현하기 위해 협력하는 공동체의 일원으로 봐야 한다.
6. 책임의 위치를 결정하기 위해 조건문을 사용하는 것은 협력의 설계 측면에서 대부분의 경우 좋지 않은 선택이다. 항상 예외 케이스를 최소화하고 일관성을 유지할 수 있는 방법을 선택하라.

## ⦿ 목차
* [1. 객체, 설계]( #1.-객체,-설계 )
* [2. 객체지향 프로그래밍]( #2-객체지향-프로그래밍 )


<br/>

## 1. 객체, 설계
* [학습 코드](https://github.com/orchsik/study-object/pull/1)
* Theater 클래스의 enter 메서드(P.17)
  ### ❌ 문제점
  1) 이해 가능한 코드란 그 동작이 우리의 예상에서 크게 벗어나지 않는 코드다. 현실에서는 관람객이 직접 자신의 가방에서 초대장을 꺼내 판매원에게 건넨다.
    판매원은 매표소에 있는 티켓을 직접 꺼내 관람객에게 건네고 관람객에게서 직접 돈을 받아 매표소에 보관한다.
  2) 메서드를 이해하기 위해서는 Audience가 Bag을 가지고 있고, Bag 안에는 현금과 티켓이 들어 있으며 TicketSeller가 TicketOffice에서 티켓을 판매하고,
    TicketOffice 돈과 티켓이 보관돼 있다는 모든 사실을 기억하고 있어야 한다. 이 코드는 하나의 클래스나 메서드에서 너무 많은 세부사항을 다루기 때문에 코드를
    작성하는 사람뿐 아니라 코드를 읽고 이해해야 하는 사람 모두에게 큰 부담을 준다.
  3) 가장 심각한 문제는 Audience와 TicketSeller를 변경할 경우 Theater도 함께 변경해야 한다는 사실이다.
  ### ✅ 개선방향
  * Theater가 Audience와 TicketSeller에 관해 너무 세세한 부분까지 알지 못하도록 정보를 차단하면 된다.
    사실 관람객이 가방을 가지고 있다는 사실과 판매원이 매표소에서 티켓을 판매한다는 사실을 Theater가 알아야할 필요가 없다.
    Theater가 원하는 것은 관람객이 소극장에 입장하는 것뿐이다. 따라서 관람객이 스스로 가방 안의 현금과 초대장을 처리하고 판매원이
    스스로 매표소의 티켓과 판매 요금을 다루게 한다면 이 모든 문제를 한 번에 해결할 수 있을 것 이다.
    다시 말해서 관람객과 판매원을 **자율적인 존재**로 만들면 되는 것이다.

<br/>

## 2. 객체지향 프로그래밍
* [학습 코드](https://github.com/orchsik/study-object/pull/2)
* 클래스를 구현하거나 다른 개발자에 의해 개발된 클래스를 사용할 때 가장 중요한 것은 클래스의 경계를 구분 짓는 것이다. 클래스는 내부와 외부로 구분되며 훌륭한 클래스를
  설계하기 위한 핵심은 어떤 부분을 외부에 공개하고 어떤 부분을 감출지를 결정하는 것이다. 클래스의 내부와 외부를 구분(구현 은닉)해야 하는 이유는 무엇일까?
  * 경계의 명확성이 객체의 자율성을 보장하기 때문이다.
  * 프로그래머에게 구현의 자유를 제공하기 때문이다. 클라이언트 프로그래머는 내부의 구현은 무시한 채 인터페이스만 알고 있어도 클래스를 사용할 수 있다.
    클래스 작성자는 인터페이스를 바꾸지 않는 한 외부에 미치는 영향을 걱정하지 않고도 내부 구현을 마음대로 변경할 수 있다.
* 협력(Collaboration)
  * 객체가 다른 객체와 상호작용할 수 있는 유일한 방법은 **메시지를 전송(send a message)** 하는 것뿐이다. 다른 객채에게 요청이 도착할 때 해당 객체가
    **메시지를 수신(receive a message)** 했다고 이야기 한다. 메시지를 수신한 객체는 스스로의 결정에 따라 자율적으로 메시지를 처리할 방법을 결정한다.
    이 처럼 수신된 메시지를 처리하기 위한 자신만의 방법을 **메서드(method)** 라고 부른다.
* 다형성
  * 다형성은 메세지에 응답하기 위해 실행될 메서드를 컴파일 시점이 아닌 실행 시점에 결정한다는 공통점이 있다.
  * 이를 **지연 바인딩(lazy binding)** 또는 동적 **바인딩(dynamic binding)** 이라고 부른다. <-> 초기 바인딩 또는 정적 바인딩.
* 부모 클래스에 기본적인 알고리즘의 흐름을 구현하고 중간에 필요한 처리를 자식에게 위임하는 디자인 패턴을 TEMPLATE METHOD 패턴이라고 부른다.
  * DiscountPolicy 클래스의 calculateDiscountAmount 메서드, getDiscountAmount 메서드 구현을 위임하고 있다.
* 헙성(Composition)
  * 합성은 상속이 가지는 두 가지 문제점을 모두 해결한다. 인터페이스에 정의된 메시지를 통해서만 재사용이 가능하기 때문에 구현을 효과적으로 캡슐화할 수 있다.
    또한 의존하는 인스턴스를 교체하는 것이 비교적 쉽기 때문에 설계를 유연하게 만든다. 상속은 클래스를 통해 강하게 결합되는 데 비해 합성은 메시지를 통해 느슨
    하게 결합된다. 따라서 코드 재사용을 위해서는 상속보다는 합성을 선호하는 거싱 더 좋은 방법이다.