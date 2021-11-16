package test;


import model.Hammer;
import model.Tool;

/**
 * 
 * 기존 제어방식
 * 사용자가 망치(컴포넌트) 를 사용하기 위해서는 Hammer 객체를 생성하고 work를 호출
 * 만약 도구를 삽으로 변경해야 한다면 객체 생성부를 수정해서 
 * new Spade() 를 명시해야 한다(추상화 또는 계층구조화 또는 캡화가 되어있지 않다면
 * 메서드 호출부 또한 변경해야 한다)
 * 
 * 이럴 경우 도구(or 컴포넌트) 가 변경될 때 마다 해당 코드 부분의 수정은 불가피하다
 *--> 사용자 측과 도구 (컴포넌트) 측과의 결합도가 높은 상태 (낮은 유지보수성)
 *
 * 계층구조화를 통해 메서드 또는 소통방식의 표준화를 시킨다
 * Interface : Tool
 * abstract method : work()
 * 
 * 현 구조에서는 컴포넌트를 변경할 때 코드 수정은 불가피하다
 */
public class testUser {
	public static void main(String[] args) {
		Tool tool = new Hammer();
		//Hammer tool = new Hammer();
		//Spade tool = new Spade();
		tool.work();
	}
}
