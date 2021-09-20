# D3

## [1289 원재의 메모리 복구하기](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV19AcoKI9sCFAZN&categoryId=AV19AcoKI9sCFAZN&categoryType=CODE&problemTitle=1289&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/SWAcademy/D3/SW1289.java)
* 원래 값에서 초기 상태로 복구하므로 스위치는 반대로 동작
* 단순히 해당 자리와 다음 자리가 다르면 스위치를 누를 수 밖에 없는 규칙을 이용할 수도 있다

## [1208 Flatten](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV139KOaABgCFAYh&categoryId=AV139KOaABgCFAYh&categoryType=CODE&problemTitle=1208&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/SWAcademy/D3/SW1208.java)
* *Collection* 의 min, max 를 이용함
* 주어진 횟수 만큼 혹은 min 과 max 의 차이가 1 이하일 때 까지 1 씩 증가/감소

## [1873 상호의 배틀필드](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LyE7KD2ADFAXc&categoryId=AV5LyE7KD2ADFAXc&categoryType=CODE&problemTitle=1873&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/SWAcademy/D3/SW1873.java)
* 전차의 좌표 (pr, pc) 와 방향 전역 변수로 저장
* 포탄이 맵 밖을 나가거나 벽에 부딪힐 때까지 재귀 호출

## [2805 농작물 수확하기](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV7GLXqKAWYDFAXB&categoryId=AV7GLXqKAWYDFAXB&categoryType=CODE&problemTitle=2805&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1)
### [Code: recursion](https://github.com/ljiwoo59/Algorithm_Java/blob/master/SWAcademy/D3/SW2805.java)
### [Code: for loop](https://github.com/ljiwoo59/Algorithm_Java/blob/master/SWAcademy/D3/SW2805_2.java)
* 마름모 구하는 공식 (*Math.abs(mid - row) <= n < N - Math.abs(mid - row)*) 을 이용하여 재귀/for loop

## [1225 암호 생성기](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14uWl6AF0CFAYD&categoryId=AV14uWl6AF0CFAYD&categoryType=CODE&problemTitle=1225&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/SWAcademy/D3/SW1225.java)
* LinkedList 에 있는 **Deque** 함수를 사용해 숫자 처리는 queue 형태 (*offer, poll*) 로, 0 이 tail 에 포함되어있는지는 stack 의 peek 를 사용

## [3499 퍼펙트 셔플](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWGsRbk6AQIDFAVW&categoryId=AWGsRbk6AQIDFAVW&categoryType=CODE&problemTitle=3499&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/SWAcademy/D3/SW3499.java)
* **Queue** 두개를 이용하여 카드덱 반으로 나눔
  * 홀수일 경우를 위해 Math.ceil() 을 이용하여 올림 계산 (첫 덱이 한장 더 가져감)

## [1228 암호문 1](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14w-rKAHACFAYD&categoryId=AV14w-rKAHACFAYD&categoryType=CODE&problemTitle=1228&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/SWAcademy/D3/SW1228.java)
* **ArrayList** 를 이용하여 인덱스 중간 삽입

## [9229 한빈이와 Spot Mart](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AW8Wj7cqbY0DFAXN)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/SWAcademy/D3/SW9229.java)
* nC2 **Combination** 을 이용하여 모든 조합을 구하고 limit 보다 작거나 같은 max sum 을 구함

## [5215 햄버거 다이어트](https://swexpertacademy.com/main/code/problem/problemDetail.do)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/SWAcademy/D3/SW5215.java)
* **부분집합** 알고리즘을 이용하여 총 경우의 수를 구해 처리

## [3307 최장 증가 부분 수열](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWBOKg-a6l0DFAWr&categoryId=AWBOKg-a6l0DFAWr&categoryType=CODE&problemTitle=3307&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1&&&&&&&&&)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/SWAcademy/D3/SW3307.java)
* **DP**
* LIS
