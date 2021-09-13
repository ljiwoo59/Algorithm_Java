# 2021 KAKAO BLIND RECRUITMENT

## [신규 아이디 추천](https://programmers.co.kr/learn/courses/30/lessons/72410)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Programmers/2021Kakao/P_NewID.java)
* **regex** 이용
  * **"[^a-z0-9\\\\-\_\\\\.]"** : 소문자 알파벳이 아니거나 숫자가 아니거나 - \_ . 가 아닌 패턴
     * [] 은 문자 집합을 뜻하고 집합 안의 ^ 는 *not*, \\\ 은 - 나 . 등 *regex* 전용 특수문자를 일반문자로 표현
  * **"\\\\.{2,}"** : . 이 2개 이상인 패턴
     * {숫자, 숫자(없으면 이상} : 연속으로 반복 되는 문자
  * **"^\\\\.|\\\\.$"** : 시작이 . 이거나 끝이 . 인 패턴
     * | 로 or 표현, ^ 는 시작, $ 는 끝 

## [순위 검색](https://programmers.co.kr/learn/courses/30/lessons/72412)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Programmers/2021Kakao/ranking.java)
* 4차원 배열을 이용하여 각각 종류의 점수를 저장
  * 접근이 빠른 *ArrayList* 사용
* 효율성 개선 필요***
