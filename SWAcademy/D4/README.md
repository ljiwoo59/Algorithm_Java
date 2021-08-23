# D4
## [1210 Ladder1](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14ABYKADACFAYh&categoryId=AV14ABYKADACFAYh&categoryType=CODE&problemTitle=1210&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1&&&&&&&&&)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/SWAcademy/D4/SW1210.java)
* Destination 부터 재귀를 이용하여 경우의 수를 하나로 줄임
* 좌우 방향을 위 방향보다 우선시 함으로서 방향 전환을 우선으로 줌

## [1218 괄호 짝짓기](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14eWb6AAkCFAYD&categoryId=AV14eWb6AAkCFAYD&categoryType=CODE&problemTitle=1218&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/SWAcademy/D4/SW1218.java)
* **Stack** 을 이용하여 스택이 비어있으면 바로 넣고 비어있지 않을 시 닫는 괄호가 스택의 *top* 의 괄호와 짝이 맞으면 *pop* 한다
* 결국 짝이 맞지 않으면 연산이 끝났을 시 스택이 비어있지 않게 됨

## [1861 정사각형 방](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LtJYKDzsDFAXc&categoryId=AV5LtJYKDzsDFAXc&categoryType=CODE&problemTitle=1861&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1) *
### [Code : 완전탐색](https://github.com/ljiwoo59/Algorithm_Java/blob/master/SWAcademy/D4/SW1861.java)
### [Code : 경우의 수 줄임](https://github.com/ljiwoo59/Algorithm_Java/blob/master/SWAcademy/D4/SW1861_2.java)
* 모든 경우를 계산할 경우, 중복 계산이 일어남
* visit 배열을 생성함으로서 이미 계산한 값을 그대로 받아옴

## [1233 사칙연산 유효성 검사](https://swexpertacademy.com/main/code/problem/problemDetail.do)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/SWAcademy/D4/SW1233.java)
* 완전 이진 트리 이므로 모든 leaf node 는 숫자, 그 외는 연산자를 가지고 있어야함

## [1223 계산기2](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14nnAaAFACFAYD&categoryId=AV14nnAaAFACFAYD&categoryType=CODE&problemTitle=1223&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/SWAcademy/D4/SW1223.java)
* **Stack** 을 이용하여 숫자면 바로 후위식에 넣고 연산자면 스택에 들어있는 연산자들과 비교하여 자신보다 같거나 큰 연산자를 후위식에 넣어주고 자신을 스택에 넣는다

## [1238 Contact](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15B1cKAKwCFAYD&categoryId=AV15B1cKAKwCFAYD&categoryType=CODE&problemTitle=1238&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1&&&&&&&&&)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/SWAcademy/D4/SW1238.java)
* **BFS** 를 이용하여 가장 마지막 노드의 제일 큰 값 구하기
