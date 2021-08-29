# Silver 1
## [2564 경비원](https://www.acmicpc.net/problem/2564)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/silver/B2564.java)
* 시계 방향, 반시계 방향으로 완전탐색
* 북서쪽 꼭짓점을 기준으로 펼치는 방법도 있다
## [16953 A->B](https://www.acmicpc.net/problem/16953)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/silver/B16953.java)
* 단순 while 문으로 구현
* **BFS** 를 이용하여 경우의 수를 구하는 방법도 있다

## [15900 나무 탈출](https://www.acmicpc.net/problem/15900)
### [Code : 시간초과](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/silver/B15900.java)
### [Code : from root](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/silver/B15900_2.java)
* leaf node 를 찾고 leaf 에서 부터 root 까지의 총합을 구하는 것은 시간 초과
* root 에서 **DFS** 를 통해 해당 node 까지의 총합 수를 넘겨주어 시간 줄임
   * ArrayList 대신 LinkedList 를 쓰면 시간 초과가 난다 

## [2841 외계인의 기타 연주](https://www.acmicpc.net/problem/2841)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/silver/B2841.java)
* **LinkedList 의 LinkedList** 를 구현하여 6개의 줄의 프렛 스택을 구현
* *addLast()* 와 *removeLast()* 를 이용함

## [5567 결혼식](https://www.acmicpc.net/problem/5567)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/silver/B5567.java)
* *tree* 의 간선을 인접행렬을 이용하여 저장
* visit 배열로 친구 중복 방지

## [2468 안전 영역](https://www.acmicpc.net/problem/2468)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/silver/B2468.java)
* 모두 물에 잠기지 않는 경우가 있으므로 result 값은 1로 초기화
* 1 부터 100 높이 까지 물이 잠겼을 경우 각각 **DFS** 를 이용하여 영역 개수 처리

## [1389 케빈 베이컨의 6단계 법칙](https://www.acmicpc.net/problem/1389)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/silver/B1389.java)
* 인접행렬을 이용하여 관계 처리
* **BFS** 를 이용하여 각 노드의 단계 합산

## [7569 토마토](https://www.acmicpc.net/problem/7576)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/silver/B7569.java)
* **Queue** 를 이용하여 **BFS** 구현
* 좌표의 층은 *r / R*
* 2차원을 3차원으로 구현해야 하므로 각 층의 제한을 *nxr >= curr[2] \* R && nxr < (curr[2] + 1) \* R* 으로 준다
* 윗층 아랫층 제한은 각각 *upr < R \* H*, *dwr >= 0* 으로 준다

## [2961 도영이가 만든 맛있는 음식](https://www.acmicpc.net/problem/2961)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/silver/B2961.java)
* *부분집합*을 이용하여 모든 경우의 수를 구한다
  * Bit 연산 이용
* 공집합은 예외처리

## [2002 추월](https://www.acmicpc.net/problem/2002)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/silver/B2002.java)
* **Queue** 두개를 이용하여 in 과 out 구현
* in 을 기준으로 out 과 비교해주면서 추월 차량 계산

## [1074 Z](https://www.acmicpc.net/problem/1074)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/silver/B1074.java)
* **분할 정복** 알고리즘
* *n* 이 1 이 될때까지 4분면으로 나누어 어느 위치에 포함되어있는지를 확인

## [2178 미로 탐색](https://www.acmicpc.net/problem/2178)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/silver/B2178.java)
* **BFS** 를 이용해서 최단 거리 구하기

## [2667 단지번호붙이기](https://www.acmicpc.net/problem/2667)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/silver/B2667.java)
* **DFS** 를 이용하여 집 개수 세기 및 인접한 영역 모두 방문하여 지우면서 단지 수 세기

## [1992 쿼드트리](https://www.acmicpc.net/problem/1992)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/silver/B1992.java)
* **분할 정복** 을 이용하여 해당 맵이 통일 하지 않을 시 4분면으로 나누어 통일 다시 확인 반복

## [15661 링크와 스타트](https://www.acmicpc.net/problem/15661)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/silver/B15661.java)
* *bit* 연산을 이용한 *subset* 구하기

## [2447 별 찍기 - 10](https://www.acmicpc.net/problem/2447)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/silver/B2447.java)
* **분할 정복**
* *2 차원 char 배열* 을 이용해서 처음 ' '로 초기화 후 9칸으로 분할해가며 1, 1 이 아닐때만 '\*' 넣어준다

## [17609 회문](https://www.acmicpc.net/problem/17609)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/silver/B17609.java)
* *left* 와 *right* 변수를 이용하여  *left* 가 *right* 보다 작거나 같을 때까지 문자 배열 비교
* 문자가 다를 시 두 가지 경우로 문자 배열 비교 함수 호출
  * *left* 를 하나 넘긴 상태에서 (left 의 문자를 지운다고 생각) *right* 와 비교
  * *right* 를 하나 넘긴 상태에서 (right 의 문자를 지운다고 생각) *left* 와 비교
  * 만약 둘중 하나라도 문자 배열이 같으면 유사 회문, 아니면 회문이 아님

---

# Silver 2
## [1541 잃어버린 괄호](https://www.acmicpc.net/problem/1541)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/silver/B1541.java)
* 제일 처음 '-' 기준으로 모두 빼버리면 된다

## [11053 가장 긴 증가하는 부분 수열](https://www.acmicpc.net/problem/11053)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/silver/B11053.java)
* DP 를 이용하여 현재 수 보다 작은 수가 있는지를 찾고
* 순열을 이루고 있는 작은 수를 현재 수를 포함해 담는다

## [1260 DFS와 BFS](https://www.acmicpc.net/problem/1260)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/silver/B1260.java)
* 2차원 배열을 이용하여 노드와 노드간의 간선 표시
  * arr[x][y] = arr[y][x]
* visit 배열로 방문한 노드 표시

## [1012 유기농 배추](https://www.acmicpc.net/problem/1012)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/silver/B1012.java)
* 2차원 배열에 배추 표시, 계산한 배추는 0으로 초기화
* **DFS** 를 이용하여 인접한 배추 초기화

## [4963 섬의 개수](https://www.acmicpc.net/problem/4963)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/silver/B4963.java)
* 2차원 배열에 섬 표시, 계산한 섬은 0으로 초기화
* **DFS** 를 이용하여 인접한 섬 초기화

---

# Silver 3
## [5397 키로거](https://www.acmicpc.net/problem/5397)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/silver/B5397.java)
* 최대 1,000,000의 문자열을 처리해야 하기 때문에 List 의  add, remove 함수 (평균 O(n)) 는 느리다
* Stack 의 push(), pop() 은 말단 노드에서 일어나기 때문에 O(1)
* 커서 기준 문자열 Stack 두개를 이용하여 push(), pop() 으로 처리

## [16926 배열 돌리기 1](https://www.acmicpc.net/problem/16926)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/silver/B16926.java)
* 재귀 호출로 2차원 배열의 회전하는 각 가장자리 부분을 1차원 배열로 저장
* **Queue** 를 이용하여 회전 구현
* 1차원 배열을 다시 2차원으로 저장

---

# Silver 4
## [1244 스위치 켜고 끄기](https://www.acmicpc.net/problem/1244)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/silver/B1244.java)
* 단순 for 문과 재귀를 이용하여 구현

---

# Silver 5
## [1158 요세푸스 문제](https://www.acmicpc.net/problem/1158)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/silver/B1158.java)
* **Queue** 를 이용하여 값을 *poll*, *offer* 하며 원형리스트 처럼 구현

## [2563 색종이](https://www.acmicpc.net/problem/2563)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/silver/B2563.java)
* 2차원 배열을 이용하여 중복계산 방지
