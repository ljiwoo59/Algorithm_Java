# Gold 2
## [3109 빵집](https://www.acmicpc.net/problem/3109)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/gold/B3109.java)
* **백트래킹**
* *dx dy* 배열을 오른쪽 위, 오른쪽, 오른쪽 아래 순을 하여 최적의 선택지 부터 확인
* **DFS** 를 이용하여 목적 열까지 도달할 수 있는 지 확인
  * 목적지까지 실패하더라도 지나온 자리는 실패한 자리기 때문에 지워주지 않는다

---

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

## [2206 벽 부수고 이동하기](https://www.acmicpc.net/problem/2206)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/gold/B2206.java)
* 2차원 visit 배열을 쓸 경우, 벽을 부수고 갔을 때와 부수지 않고 돌아갔을 때 방문 처리가 중복되어 반례가 생김
* 3차원 visit 배열을 이용하여, 벽을 부쉈을 때, 부수지 않았을 때의 두가지 방문 배열을 생성
* **BFS** 를 이용하여 최단 거리 구하기

## [16236 아기 상어](https://www.acmicpc.net/problem/16236)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/gold/B16236.java)
* *Fish* 클래스를 만들어 *row, col, dist* 정보 저장 및 **Comparable** *implements* 하여 주어진 기준으로 정렬
* 현재 위치에서 **BFS** 를 이용하여 최단 거리의 물고기들을 저장 및 정렬 (*head* 에 있는 물고기가 주어진 기준 최단 거리 물고기)
* 더이상 선택할 물고기가 없을 때 까지 반복

## [2580 스도쿠](https://www.acmicpc.net/problem/2580)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/gold/B2580.java)
* **백트래킹**
* 빈칸인 자리들을 미리 **stack** 에 넣어 스택이 비면 재귀 종료
* 빈칸 자리에 1 부터 9 까지 시도해 보며 유망성 체크
  * 행, 열 확인, 3 \* 3 구역 확인
* 모든 수가 유망하지 않다면 *map* 을 빈칸으로 초기화, 해당 빈칸 정보를 다시 스택에 넣어준다

## [3055 탈출](https://www.acmicpc.net/problem/3055)
## [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/gold/B3055.java)
* **BFS** 를 이용하여 매 분마다 비버 이동 후, 물 차오르기 구현
  * 비버가 갈 곳이 없거나 (queue 가 비었거나) 도착지에 도착하면 종료

## [1197 최소 스패닝 트리](https://www.acmicpc.net/problem/1197)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/gold/B1197.java)
* **Kruskal Algorithm**
  * *Union-Find set*
* **PriorityQueue** 를 이용하여 간선 가중치 오름차순 정렬

## [1922 네트워크 연결](https://www.acmicpc.net/problem/1922)
### [Code]()
* **Kruskal Algorithm**
  * *Union-Find set*
* **PriorityQueue** 를 이용하여 간선 가중치 오름차순 정렬

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

## [12865 평범한 배낭](https://www.acmicpc.net/problem/12865)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/gold/B12865.java)
* **DP** 2차원 배열을 이용
  * *row* 는 현재까지 고려하는 item index
  * *col* 은 현재까지 고려하는 bag weight
  * *row, col* 은 현재까지 고려한 bag weight 에 현재까지 고려한 item 중 넣을 수 있는 최대 값어치
* **dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - W[i]] + V[i])**
  * *이전 item 까지 고려했을 때의 최대 값어치 (현재 item 을 보지 않은) **vs** 현재 item 을 넣기 위해 이전 item 을 고려하고 bag weight 가 현재 item 을 넣을 수 있는 최대 무게의 값어치*

## [9663 N-Queen](https://www.acmicpc.net/problem/9663)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/gold/B9663.java)
* **백트래킹**
* *1차원 배열* 을 이용하여 각 *col index* 당 *row index*를 저장
  * 한 행에 하나의 퀸만 놓는다
* 1 부터 N 까지의 *row index* 를 시도해 봄으로서 유망성 체크
  * 이전 퀸들과 행, 열이 같거나 대각선이면 종료

## [1759 암호 만들기](https://www.acmicpc.net/problem/1759)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/gold/B1759.java)
* 사전 순 출력이므로 알파벳 배열을 미리 정렬
* **조합** 을 이용하는데, 자음인지 모음인지 확인 후 각각 카운트가 올라가는 재귀 호출
* 자음이 최소 2개 이상, 모음이 최소 1개 이상일 때만 출력

## [9019 DSLR](https://www.acmicpc.net/problem/9019)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/gold/B9019.java)
* **BFS** 를 이용하여 최단 경우의 수 구하기
* 시도한 *command* 를 출력해야 하기에 현재 숫자와 지금까지의 *command* 를 가지는 객체 생성

## [5015 스타트링크](https://www.acmicpc.net/problem/5014)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/gold/B5014.java)
* **BFS** 를 이용하여 최단 경우의 수 구하기
* *9019 DSLR* 과 유사한 문제지만 시도한 경로를 출력할 필요가 없음


