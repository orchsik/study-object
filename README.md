## ⦿ 목차
* [1. 객체, 설계]( #1-객체,-설계 )
* [2. 객체지향 프로그래밍]( #2-객체지향-프로그래밍 )
* [3. 역할,책임,협력]( #3-역할-책임-협력 )
* [4. 설계 품질과 트레이드오프]( #4-설계-품질과-트레이드-오프 )
* [5. 책임 할당하기]( #5-책임-할당하기 )
* [6. 메시지와 인터페이스]( #6-메시지와-인터페이스 )
* [10. 상속과 코드 재사용]( #10-상속과-코드-재사용 )
* [11. 합성과 유연한 설계]( #11-합성과-유연한-설계 )
* [12. 다형성]( #12-다형성 )


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
5. 어떤 클래스가 필요한지를 고민하기 전에 어떤 객체들이 필요한지 고민하라. 객체를 독립적인 존재가 아니라 기능을 구현하기 위해 협력하는 공동체의 일원으로 봐야 한다.
6. 책임의 위치를 결정하기 위해 조건문을 사용하는 것은 협력의 설계 측면에서 대부분의 경우 좋지 않은 선택이다. 항상 예외 케이스를 최소화하고 일관성을 유지할 수 있는 방법을 선택하라.
7. 캡술화? 변경 가능성이 높은 부분을 객체 내부로 숨기는 추상화 기법이다. 변경될 수 있는 어떤 것이라도 캡슐화해야 한다.
8. 데이터보다 행동을 먼저 결정하라. 협력이라는 문맥 안에서 책임을 결정하라.
9. 객체에게 책임을 할당하는 첫 번째 원칙은 책임을 수행할 정보를 알고 있는 객체에게 책임을 할당하는 것이다.
10. 상속 원칙
  * 두 메서드가 유사하게 보인다면 차이점을 메서드로 추출하라. 메서드 추출을 통해 두 메서드를 동일한 형태로 보이도록 만들 수 있다.
  * 부모 클래스의 코드를 하위로 내리지 말고 자식 클래스의 코드를 상위로 올려라. 부모 클래스의 구체적인 메서드를 자식 클래스로 내리는 것보다 자식 클래스의 추상적인 메서드를
    부모 클래스로 올리는 것이 재사용성과 응집도 측면에서 더 뛰어난 결과를 얻을 수 있다. 

## ⦿ 클래스 응집도 판단하기
  1. 클래스가 하나 이상의 이유로 변경돼야 한다면 응집도가 낮은 것이다. 변경의 이유를 기준으로 클래스를 분리하라.
  2. 클래스의 인스턴스를 초기화하는 시점에 경우에 따라 서로 다른 속성들을 초기화하고 있다면 응집도가 낮은 것이다.
    초기화되는 속성의 그룹을 기준으로 클래스를 분리하라.
  3. 메서드 그룹이 속성 그룹을 사용하지 여부로 나뉜다면 응집도가 낮은 것이다. 이들 그룹을 기준으로 클래스를 분리하라.

---
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

<br/>

## 3. 역할, 책임, 협력
* [학습 코드](실습 코드가 없어요.)
* 협력이란 어떤 객체가 다른 객체에게 무엇인가를 요청하는 것이다. 한 객체는 어떤 것이 필요할 때 다른 객체에게 전적으로 위임하거나
  서로 협력한다. 즉, 두 객체가 상호작용을 통해 더 큰 책임을 수행하는 것이다. 객체 사이의 협력을 설계할 때는 객체를 서로 분리된
  인스턴스가 아닌 협력하는 파트너로 인식해야 한다.
* 협력을 설계하기 위해서는 책임(객체의 행동)에 초점을 맞춰야 한다. 어떤 책임을 선택하느냐가 전체적인 설계의 방향과 흐름을 결정한다.
  이처럼 책임을 갖고 책임을 수행할 적절한 객체를 찾아 책임을 할당하는 방식으로 협력을 설계하는 방법을 **책임 주도 설계(Responsibility-Driven Design, RDD)** 라 부른다.
  * 객체에게 책임을 할당하는 데 필요한 메시지를 먼저 식별하고 메시지를 처리할 객체를 나중에 선택한다. 객체가 메시지를 선택하는 것이 아니라 메시지가 객체를 선택하게 한다.
  * 객체가 존재하는 이유는 협력에 참여하기 위해서다. 따라서 객체는 협력에 필요한 행동을 제공해야 한다. 객체를 객체답게 만드는 것은 객체의 상태가 아니라 객체가 다른 객체에게 제공하는 행동이다.

<br/>

## 4. 설계 품질과 트레이드 오프
* [학습 코드](https://github.com/orchsik/study-object/pull/4)
* 캡술화? 변경 가능성이 높은 부분을 객체 내부로 숨기는 추상화 기법이다.
* 응집도? 모듈에 포함된 내부 요소들이 연관돼 있는 정도를 나타낸다. 모듈 내의 요소들이 **하나의 목적** 을 위해 긴밀하게 협력한다면 그 모듈은 높은 응집도를 가진다.
* 결합도? 의존성의 정도를 나타내며 다른 모듈에 대해 얼마나 많은 지식을 갖고 있는지를 나타내는 척도다. 어떤 모듈이 다른 모듈에 대해 꼭 필요한 지식만 알고 있다면
  두 모듈은 낮은 결합도를 가진다.
* 데이터 중심 설계의 문제점
  * ⦿ 캡슐화 위반
    1. 접근자 메서드를 사용하면 직접 객체의 내부에 접근할 수 없기 때문에 캡슐화의 원칙을 지키고 있는 것처럼 보인다.
      하지만 접근자와 수정자 메서드는 객체 내부의 상태에 대해 어떤 정보도 캡슐화하지 못한다. 클래스 내부에 특정 타입의 데이터가 존재한다는 사실을
      퍼블릭 인터페이스에 노골적으로 드러낸다. 
  * ⦿ 높은 결합도, 낮은 응집도
    1. 데이터의 타입 변경으로 인해 협력하는 클래스가 변경되기 때문에 접근자 메서드는 데이터를 정상적으로 캡슐화하지 못 한다.
    2. 데이터 중심의 설계는 여러 데이터 객체들을 사용하는 제어 로직이 특정 객체 안에 집중되기 때문에 하나의 제어 객체가 다수의 데이터 객체에 강하게 결합된다는 것이다.
      이 결합도로 인해 어떤 데이터 객체를 변경하더라도 제어 객체를 함께 변경할 수 밖에 없다.
  * ⦿ 객체의 행동보다는 상태에 초점을 맞춘다.
    1. 데이터 중심의 설계를 시작할 때 던졌던 첫 번째 질문은 "이 객체가 포함해야 하는 데이터가 무엇인가?"다. 데이터는 구현의 일부라는 사실을 명심하라.
      데이터 주도 설계를 시작하는 처음부터 데이터에 관해 결정하도록 강요하기 때문에 너무 이른 시기에 내부 구현에 초점을 맞추게 한다.
  * ⦿ 객체를 고립시킨 채 오퍼레이션을 정의하도록 만든다.
    1. 객체지향 애플리케이션을 구현한다는 것은 협력하는 객체들의 공동체를 구축한다는 것을 의미한다. 따라서 협력이라는 문맥 안에서 필요한 책임을 결정하고 이를 수행할
      적절한 객체를 결정하는 것이 가장 중요하다. 올바른 객체지향 설계의 무게 중심은 항상 객체의 내부가 아니라 외부에 맞춰져 있어야 한다. 객체가 내부에 어떤 상태를
      가지고 그 상태를 어떻게 관리하는가는 부가적인 문제다. 중요한 것은 객체가 다른 객체와 협력하는 방법이다.

<br/>

## 5. 책임 할당하기
* [학습 코드](https://github.com/orchsik/study-object/pull/5)
* 책임 주도 설계
  * 시스템이 사용자에게 제공해야 하는 기능인 시스템 책임을 파악한다.
  * 시스템 책임을 더 작은 책임으로 분할한다.
  * 분할된 책임을 수행할 수 있는 적절한 객체 또는 역할을 찾아 책임을 할당한다.
  * 객체가 책임을 수행하는 도중 다른 객체의 도움이 필요한 경우 이를 책임질 적절한 객체 또는 역할을 찾는다.
  * 해당 객체 또는 역할에게 책임을 할당함으로써 두 객체가 협력하게 한다.
* 책임 할당을 위한 GRASP(General Responsibility Assignment Software Pattern) 패턴
  * 도메인 개념에서 출발하기
  * 정보 전문가에게 책임을 할당하라
  * 높은 응집도와 낮은 결합도
  * 창조자에게 객체 생성 책임을 할당하라

<br/>

## 6. 메시지와 인터페이스
* [학습 코드](https://github.com/orchsik/study-object/pull/6)
* 협력과 메시지 (클라이언트-서버 모델)
  * 메시지: 객체가 다른 객체와 협력하기 위해 사용하는 의사소통 매커니즘. 일반적으로 객체의 오퍼레이션이 실행되도록 요청하는 것을
    "메시지 전송"이라고 부른다. 메시지는 협력에 참여하는 전송자와 수신자 양쪽 모두를 포함하는 개념이다.
  * 오퍼레이션: 객체가 다른 객체에게 제공하는 추상적인 서비스다. 메시지가 전송자와 수신자 사이의 협력 관계를 강조하는 데 비해
    오페레이션은 메시지를 수신하는 객체의 인터페이스를 강조한다. 다시 말해서 메시지 전송자는 고려하지 않은 채 메시지 수신자의 관점만을 다룬다.
    메시지 수신이란 메시지에 대응되는 객체의 오퍼레이션을 호출하는 것을 의미한다.
  * 메서드: 메시지에 응답하기 위해 실행되는 코드 블록을 메서드라고 부른다. 메서드는 오퍼레이션의 구현이다. 동일한 오퍼레이션이라고
    해도 메서드는 다를 수 있다. 오퍼레이션과 메서드의 구분은 다형성의 개념과 연결된다.
  * 시그니처: 오퍼레이션이나 메서드의 명세를 나타낸 것으로, 이름과 인자 목록을 포함한다. 대부분의 언어는 시그니처의 일부로 반환 타입을 포함하지
    않지만 반환 타입을 시그니처의 일부로 포함하는 언어도 존재한다.
* 인터페이스와 설계 품질
  * 디미터 법칙은 하나의 도트(.)를 강제하는 규칙이 아니다. 클래스 내부의 메서드가 아래 조건을 만족하는 인스턴스에게만 메시지를 전송하도록 프로그래밍 해야한다.
    1) this 객체
    2) 메서드의 매개변수
    3) this의 속성
    4) this의 속성인 컬렉션의 요소
    5) 메서드 내에서 생성된 지역 객체
  * 객체의 상태를 묻지 말고 원하는 것을 시켜라
  * 의도를 드러내는 인터페이스 - 어떻게 하느냐가 아니라 무엇을 하느냐에 따라 이름을 지어라.
* 명령-쿼리 분리 원칙
  * 명령 = 프로시저, 부수효과를 발생시킬수 있지만 값을 반환할 수 없다.
  * 쿼리 = 함수, 값을 반환할 수 있지만 부수효과를 발생시킬 수 없다.
  * 어떤 메서드가 부수효과를 가지는지를 확인하기 위해 코드를 일일이 다 분석하는 것보다는 메서드가 반환 값을 가지는지 여부만 확인하는 것이 훨씬
    간단하지 않겠는가?
  * 명령-쿼리 분리와 참조 투명성, 불변성(immutability), 부수효과❌
  * 위에 설명한 모든 것이 결국 책임 주도 설계를 통해 달성될 수 있다.

<br/>

### 7. 객체 분해 (코드 없음)
### 8. 의존성 관리하기 (코드 없음)
### 9. 유연한 설계 (코드 없음)

<br/>

## 10. 상속과 코드 재사용
  * [학습 코드](https://github.com/orchsik/study-object/pull/7)
  * 잘못된 상속과 중복 코드  
    * DRY 원칙 위반
    * 타입 코드의 값에 따라 로직을 분기시켜 중복을 피할 수 있지만, 타입 코드를 사용하는 클래스는 낮은 응집도와 높은 결합도 문제에 시달린다.
    * 잘못된 상속은 결합도를 높이고 변경을 어렵게 만든다.
  * 취약한 기반 클래스 문제, 중복 코드를 유발하는 상속의 문제점
    * 불필요한 인터페이스 상속 문제
    * 메서드 오버라이딩의 오작용 문제
    * 부모 클래스와 자식 클래스의 동시 수정 문제
  * 상속 원칙
    * 두 메서드가 유사하게 보인다면 차이점을 메서드로 추출하라. 메서드 추출을 통해 두 메서드를 동일한 형태로 보이도록 만들 수 있다.
    * 부모 클래스의 코드를 하위로 내리지 말고 자식 클래스의 코드를 상위로 올려라. 부모 클래스의 구체적인 메서드를 자식 클래스로 내리는 것보다 자식 클래스의 추상적인 메서드를
    부모 클래스로 올리는 것이 재사용성과 응집도 측면에서 더 뛰어난 결과를 얻을 수 있다. 

<br/>

## 11. 합성과 유연한 설계
  * [학습 코드](https://github.com/orchsik/study-object/pull/8)  
  * 합성의 이점
    * [코드 재사용을 위해서는] 객체 합성이 클래스 상속보다 더 좋은 방법이다.
    * 상속과 합성은 재사용의 대상이 다르다. 상속은 부모 클래스 안에 구현된 코드 자체를 재사용하지만 합성은 포함되는
      객체의 퍼블릭 인터페이스를 재사용한다. 따라서 상속 대신 합성을 사용하면 구현에 대한 의존성을 인터페이스에 대한
      의존성으로 변경할 수 있다. 다시 말해서 클래스 사이의 높은 결합도를 객체 사이의 낮은 결합도로 대체할 수 있는 것 이다.
  * 상속으로 인한 조합의 폭발적인 증가
    * 부모 클래스의 메서드를 재사용하기 위해 super 호출을 사용하면 원하는 결과를 쉽게 얻을 수 있지만 자식 클래스와 부모 클래스 사이의 결합도가 높아지고 만다.
      결합도를 낮추는 방법은 자식 클래스가 부모 클래스의 메서드를 호출하지 않도록 부모 클래스에 추상 메서드를 제공하는 것이다.
    * 훅 메서드(hook method)? 추상 메서드와 동일하게 자식 클래스에서 오버라이딩할 의도로 메서드를 추가했지만 편의를 위해 기본 구현을 제공하는 메서드
    * 단일 상속만 지원하는 경우, 상속으로 인해 발생하는 중복 코드 문제를 해결하기가 쉽지 않다.
  * 합성 관계로 변경
    * 각 정책을 별도의 클래스로 구현하는 것이다. 분리된 정책들을 연결할 수 있도록 합성 관계를 이용해서 구조를 개선하면 실행 시점에 정책들들을 조합할 수 있게 된다.
    * 다양한 종류의 객체와 협력하기 위해 합성 관계를 사용하는 경우에는 합성하는 객체의 타입을 인터페이스나 추상 클래스로 선언하고 의존성 주입을 사용해 런타임에
      필요한 객체를 생성할 수 있도록 구현하는 것이 일반적이다.
    * 부가 정책은 기본 정책이나 다른 부가 정책의 인스턴스를 참조할 수 있어야 한다. 다시 말해서 부가 정책의 인스턴스는 어떤 종류의 정책과도 합성될 수 있어야 한다.
      Phone의 입장에서는 자신이 기본 정책의 인스턴스에게 메시지를 전송하고 있는지, 부가 정책의 인스턴스에게 메시지를 전송하고 있는지를 몰라야 한다. 다시 말해서
      기본 정책과 부가 정책은 협력 안에서 동일한 `역할`을 수행해야 한다. 이것은 부가 정책이 기본 정책과 동일한 RatePolicy 인터페이스를 구현해야 한다는 것을 의미한다.
  * 상속을 사용하면 안 되는 것인가? 상속을 사용해야 하는 경우는 언제인가?
    * 상속은 구현 상속과 인터페이스 상속이 있다. 13장을 읽으면 구현 상속을 피하고 인터페이스 상속을 사용해야 하는 이유를 알 수 있다.
  * 믹스인
    * 객체를 생성할 때 코드 일부를 클래스 안에 섞어 넣어 재사용하는 기법이다.
    * 합성이 실행 시점에 객체를 조합하는 재사용 방법이라면 믹스인은 컴파일 시점에 필요한 코드 조각을 조합하는 재새용 방법이다.
    * 상속과 다르다. 믹스인은 말 그대로 코드를 다른 코드 안에 섞에 넣기 위한 방법이다. (상속의 목적은 자식 클래스를 부모 클래스와 동일한 개념적인 범주로 묶어 is-a 관계를 만드는 것)
    * 상속이 클래스와 클래스 사이의 관계를 고정시키는 데 비해 믹스인은 유연하게 관계를 재구성할 수 있다.

<br/>

## 12. 다형성
  * [학습 코드](https://github.com/orchsik/study-object/pull/9)  
  * 상속의 목적은 코드 재사용이 아닌 서브타입의 구현이다. 코드 재사용을 목적으로 상속을 사용해서는 안 된다.
    상속은 프로그램을 구성하는 개념들을 기반으로 다형성을 가능하게 하는 타입 계층을 구축하기 위한 것 이다.
  * 다형성
    * 오버로딩 다형성 : 일반적으로 하나의 클래스 안에 동일한 이름의 메서드가 존재하는 경우.
    * 강제 다형성 : 언어가 지원하는 자동적인 타입 변환이나 사용자가 직접 구현한 타입 변환을 이용해 동일한 연산자를
      다양한 타입에 사용할 수 있는 방식을 가리킨다.
    * 매개변수 다형성 : 제네릭 프로그래밍과 관련이 높은데 클래스의 인스턴스 변수나 메서드 매개변수 타입을 임의의 타입으로 선언한 후
      사용하는 시점에 구체적인 타입을 지정하는 방식을 가리킨다. 
    * 포함 다형성 : 메시지가 동일하더라도 수신한 객체의 타입에 따라 실제로 수행되는 행동이 달라지는 능력을 의미한다.
      포함 다형성은 **서브타입(Subtype) 다형성** 이라고도 부른다.
  * 업캐스팅과 동적 바인딩
    * 같은 메시지, 다른 메서드
    * 업캐스팅 : 부모 클래스 타입으로 선언된 변수에 자식 클래스의 인스턴스를 할당하는 것이 가능하다.
    * 동적 바인딩 : 선언된 변수의 타입이 아니라 메시지를 수신하는 객체의 타입에 따라 실행되는 메서드가 결정된다. 이것은 객체지향 시스템이 메시지를
      처리할 적절한 메서드를 컴파일 시점이 아니라 실행 시점에 결정하기 때문에 가능하다.