# Gold 3
## [1937 욕심쟁이 판다](https://www.acmicpc.net/problem/1937)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/gold/B1937.java)
* **DFS** 이용하여 방문한 구간 값 받아와 누적해 반환

---

# Gold 4
## [1987 알파벳](https://www.acmicpc.net/problem/1987)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/gold/B1987.java)
* visit 배열을 이용하여 지나간 캐릭터 값 확인
* **DFS** 를 이용하여 도달할 수 있는 최장 거리 값 구하기

## [1520 내리막 길](https://www.acmicpc.net/problem/1520)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/gold/B1520.java)
* 단순 **DFS** 이용시 시간 초과가 나므로 방문한 곳은 dp 배열로 값 받아오기
* 계산한 곳과 안한 곳 차이를 두기위해 dp 배열은 -1로 초기화

## [17135 캐슬 디펜스](https://www.acmicpc.net/problem/17135)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/gold/B17135.java)
* 조합 알고리즘을 이용하여 궁수 조합 완성 후 적 리스트가 빌 때가지 while 문
  * 각 조합 당 시뮬레이션을 해야하기 때문에 원본 대신 적 리스트 copy 를 이용한다
* 각 궁수 당 사거리 이하의 최단 거리 적 중 가장 왼쪽 적을 봐야 한다
* 각 궁수가 같은 적을 볼 수 있기에 죽일 적을 저장하고 모든 궁수의 최단거리 계산 이후 삭제

---

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

## [9251 LCS](https://www.acmicpc.net/problem/9251)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/gold/B9251.java)
* 각 스트링을 *행렬*로 구현
* 현재 캐릭터가 같으면 *i - 1*, * j - 1* (각자의 이전 캐릭터 위치) 의 값 + 1
* 다르면 이전 캐릭터들 중 제일 긴 수열 값을 가진 값을 받아온다 (*i*, *j - 1* or *i - 1*, *j*)

## [5582 공통 부분 문자열](https://www.acmicpc.net/problem/5582)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/gold/B5582.java)
* 수열이 아니라 문자열이기 때문에 현재 캐릭터가 같을 때만 이전 값을 받아 온다

## [2589 보물섬](https://www.acmicpc.net/problem/2589) **
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/gold/B2589.java)
* 각 육지 좌표로부터 다른 육지 좌표까지의 최단 거리 중 제일 긴 값
* 최단 거리를 구하는 **bfs** 를 이용하여 현재 육지 좌표 기준 각 육지의 거리를 구한 뒤 max 값 저장

## [15686 치킨 배달](https://www.acmicpc.net/problem/15686)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/gold/B15686.java)
* **ArrayList** 를 이용하여 집과 치킨집 좌표 저장
* *Combination* 재귀를 통해 치킨집 경우의 수 구한 뒤 *min* 계산

## [10026 적록색약](https://www.acmicpc.net/problem/10026)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/gold/B10026.java)
* **DFS** 이용해서 붙어있는 지역 하나로 통일
* 일반인과 색맹 구별용 다른 **DFS** 구현

## [1461 도서관](https://www.acmicpc.net/problem/1461)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/gold/B1461.java)
* **Greedy** 알고리즘을 이용하여 각 음수 배열, 양수 배열의 가장 큰 절대값을 *result* 에 더해주고 M 만큼 *pop*
* 전체 수 중 max 값은 *result* 에서 빼준다
