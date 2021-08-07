# Gold 5
## [4358 생태학](https://www.acmicpc.net/problem/4358)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/gold/B4358.java)
* O(log n) 시간의 TreeMap 을 이용하여 자동정렬

## [14502 연구소](https://www.acmicpc.net/problem/14502)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/gold/B14502.java)
* DFS 를 이용하여 3개의 벽을 세울 수 있는 경우 완전 탐색
* 벽 3개를 세웠을 시 바이러스의 퍼짐 재귀로 구현
* 빈칸의 최대 값 출력

## [6198 옥상 정원 꾸미기](https://www.acmicpc.net/problem/6198) ***
### [Code: recursion](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/gold/B6198.java)
### [Code: stack](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/gold/B6198_2.java)
* *long* 을 이용하여 integer range 가 넘어가는 경우 처리
* 재귀를 통해 완전 탐색 -> 속도가 느리다 (이중 for 문과 비슷)
* 단일 for 문과 stack 을 사용하여 속도 개선
  * 빌딩 높이를 감소 순으로 놓기 위해 전 빌딩이 현 빌딩과 높이가 같거나 작으면 *pop* 해준다
  * 현재 스택 사이즈를 *sum* 에 더해줌으로서 현 빌딩을 바라보고 있는 전 빌딩들의 총 개수를 더해준다
  * 스택에 현 빌딩을 *push* 한다

## [2493 탑](https://www.acmicpc.net/problem/2493) ***
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/gold/B2493.java)
* 빌딩의 높이와 인덱스를 받는 **Stack** 이용
  * *Stack* 이 비어있지 않을 경우, *top* 빌딩과 비교하여 현재 빌딩이 높을 경우, 계속 *pop* 해준다
  * *top* 빌딩이 현재 빌딩보다 높을 경우, 수신하는 빌딩은 *top* 빌딩이므로 인덱스를 출력한다
  * 현재 빌딩을 *push* 해준다
  * 결국엔 감소 순으로 스택에 넣는다
* 처음 시도했던 로직은 왜 안되는지 모름

## [3190 뱀](https://www.acmicpc.net/problem/3190)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/gold/B3190.java)
* **LinkedList** 이용하여 뱀 머리와 꼬리 구현
* 사방탐색 시계 방향, 반시계 방향 으로 머리 회전 구현

## [2075 N번째 큰 수](https://www.acmicpc.net/problem/2075)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/gold/B2075.java)
* 메모리 제한 때문에 **Priority Queue** 로 구현
  * *SortedList* 와 다르게 내부에 순서대로 저장되는 것이 아니라 *head* 에 우선순위가 가장 높은 수가 위치한다
* N 번째 큰 수가 목표기 때문에 큐 사이즈가 N 초과이면 *poll* 을 해주면서 우선순위가 높은 수(제일 작은 수) 를 삭제한다
  * 삽입이 끝난 후 *head* 에 위치한 수가 정답
