# Gold 1
## [11401 이항 계수 3](https://www.acmicpc.net/problem/11401)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/gold/B11401.java)
* **페르마의 소정리**
  * a % p 의 역원은 pow(a, p - 2)
* **이진 탐색**

## [1194 달이 차오른다, 가자.](https://www.acmicpc.net/problem/1194)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/gold/B1194.java)
* *3차원 visit 배열*을 이용하여 키를 드는 가짓 수 마다 처리
  * 키를 들고 왔던 길을 되돌아가야 할 수 있으므로
* **비트마스킹**을 이용하여 들고 있는 키의 경우의 수 처리
  * 총 6가지 키가 있으므로 *1<<6*
  * 키를 집으면 **|** 연산으로 처리
  * 문과 비교할 때는 **&** 연산으로 처리

---

# Gold 2
## [3109 빵집](https://www.acmicpc.net/problem/3109)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/gold/B3109.java)
* **백트래킹**
* *dx dy* 배열을 오른쪽 위, 오른쪽, 오른쪽 아래 순을 하여 최적의 선택지 부터 확인
* **DFS** 를 이용하여 목적 열까지 도달할 수 있는 지 확인
  * 목적지까지 실패하더라도 지나온 자리는 실패한 자리기 때문에 지워주지 않는다

## [17472 다리 만들기 2](https://www.acmicpc.net/problem/17472)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/gold/B17472.java)
* **DFS** 를 이용하여 섬마다 번호 붙이기
* **BFS** 를 이용하여 각 섬에서 다른 섬 까지의 다리 시도
* **Kruskal** 을 이용하여 모든 섬을 연결하는 다리 길이의 최소값 구하기

## [17143 낚시왕](https://www.acmicpc.net/problem/17143)
### [Code1](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/gold/B17143.java)
* 3차원 배열 맵 (초, row, column)을 이용
### [Code2](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/gold/B17143_2.java)
* *LinkedList* 배열을 이용하여 각 col 당 상저 정보 저장
* 속도 값은 **해당 행/열 최대값 - 1 * 2 의 모듈러 연산**으로 불필요한 중복연산 방지

---

# Gold 3
## [1937 욕심쟁이 판다](https://www.acmicpc.net/problem/1937)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/gold/B1937.java)
* **DFS** 이용하여 방문한 구간 값 받아와 누적해 반환

## [1941 소문난 칠공주](https://www.acmicpc.net/problem/1941)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/gold/B1941.java)
* **조합**을 이용하여 이다솜파가 4개 이상인 조합 구하기
* **DFS** 를 이용하여 연결 확인

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
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/gold/B1922.java)
* **Kruskal Algorithm**
  * *Union-Find set*
* **PriorityQueue** 를 이용하여 간선 가중치 오름차순 정렬

## [4485 녹색 옷 입은 애가 젤다지?](https://www.acmicpc.net/problem/4485)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/gold/B4485.java)
* **Dijkstra Algorithm**
* **PriorityQueue** 를 이용하여 사방탐색으로 갈 수 있는 경로의 **최소 누적 비용**을 오름차순 정렬

## [1261 알고스팟](https://www.acmicpc.net/problem/1261)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/gold/B1261.java)
* **Dijkstra Algorithm**
* **PriorityQueue** 를 이용하여 사방탐색으로 갈 수 있는 경로의 **최소 누정 비용**을 오름차순 정렬

## [5052 전화번호 목록](https://www.acmicpc.net/problem/5052)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/gold/B5052.java)
* String 의 정렬을 이용하면 접두어 정렬 순이 된다
* String 의 *startsWith* 를 사용하여 접두어에 위치하면 바로 종료

## [1939 중량 제한](https://www.acmicpc.net/problem/1939)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/gold/B1939.java)
* ***Binary Search*** 를 이용하여 경우의 수 줄이기
  * min = 1, max = 다리의 최대 중량, mid = (max + min) / 2
  * 이진 탐색을 반복하며 min 또는 max 를 업데이트 해준다
* **BFS** 를 이용하여 시작 섬에서 도착섬 탐색
  * 주어진 mid 보다 다리의 중량이 작아 도착섬에 도달하지 못하면 max = mid - 1 로 업데이트
  * 주어진 mid 에 도착섬에 도달하면 min = mid + 1 로 업데이트

## [1600 말이 되고픈 원숭이](https://www.acmicpc.net/problem/1600)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/gold/B1600.java)
* **3차원 visit 배열**을 사용하여 각 남은 점프 당 방문 체크
* **BFS**를 사용하여 도착점까지의 최단 거리

## [14002 가장 긴 증가하는 부분 수열 4](https://www.acmicpc.net/problem/14002)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/gold/B14002.java)
* **DP**
* **LIS**

## [1647 도시 분할 계획](https://www.acmicpc.net/problem/1647)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/gold/B1647.java)
* **MST**
* 최소 신장 트리 완성 후 제일 큰 가중치 빼기

## [17144 미세먼지 안녕!](https://www.acmicpc.net/problem/17144)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/gold/B17144.java)
* *tmp 배열*을 이용하여 미세먼지 확산 저장
* *재귀*를 사용하여 공기 순환 구현

## [2573 빙산](https://www.acmicpc.net/problem/2573)
### [Code1](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/gold/B2573.java)
* 시간초과....WHY?
* *Ice* 객체를 만들어 리스트에 저장
* 리스트가 빌때 까지 loop
  * 한번에 녹이기 위해 remove 배열에 추가
  * dfs 를 1회 수행하여 한 덩이인지를 판별
### [Code2](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/gold/B2573_2.java)
* 빙산을 저장하지 않고 바다 관점으로 접근
* 파싱받을 때 빙산 개수 세기
* 빙산이 0이 될때까지 loop
  * 바다를 큐에 저장하며 주위에 빙산이 있으면 높이 낮히기 

## [15961 회전 초밥](https://www.acmicpc.net/problem/15961)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/gold/B15961.java)
* **슬라이딩 윈도우**
* 초기 윈도우 배열 만들기
  * 종류의 가짓수를 더한다
  * 쿠폰을 사용할 수 있으면 1 추가
* 다음 원소부터 N 까지 윈도우 옮기기
  * 종류의 가짓수 변동 확인
  * *(현재 원소 + 연속 접시 수 - 1) % 총 접시 수)* 를 사용하여 다음 윈도우 원소 넣기
  * 쿠폰을 사용할 수 있으면 1 추가 (중복 되지 않았는지 체크)

## [2151 거울 설치](https://www.acmicpc.net/problem/2151)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/gold/B2151.java)
* **BFS**
* 거울의 방향에 따라 방문이 달라지기 때문에 거울로 쏘는 방향마다의 3차원 방문 배열
* 거울을 두지 않았을 때, 거울에 반사될 때 양쪽의 경우 시도

## [3865 학회원](https://www.acmicpc.net/problem/3865)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/gold/B3865.java)
* **HashMap<String, HashSet<String>>**
  * Key : 학회
  * Value : 학회원
  * 학회원이 중복되지 않도록 *HashSet* 사용
* 첫번째 학회의 학회원 수를 구하므로, 첫번째 학회 기준으로 다른 학회 언급 시, 재귀를 타고 들어간다
  * 학회 방문 배열을 생성하여 무한 재귀 방지
 
## [3663 고득점](https://www.acmicpc.net/problem/3663)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/gold/B3663.java)
* **문자열**
* *name[i] - 'A' 와 'Z' - name[j] + 1* 중 작은 값 합산
* 각 자리 기준 다음으로 바꿀 자리로 가는데 왼쪽으로 갈지 오른쪽으로 갈지 결정
 
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

## [1753 최단 경로](https://www.acmicpc.net/problem/1753)
### [Code : 기존 방식](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/gold/B1753.java)
### [Code2 : PriorityQueue](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/gold/B1753_2.java)
* **Dijkstra Algorithm**

## [1916 최소 비용 구하기](https://www.acmicpc.net/problem/1916)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/gold/B1916.java)
* **Dijkstra Algorithm**

## [16234 인구 이동](https://www.acmicpc.net/problem/16234)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/gold/B16234.java)
* **DFS** 를 이용해서 각 연합을 한번에 구하고
* 연합 당 저장 해놓은 인구 수 넣어준다

## [5430 AC](https://www.acmicpc.net/problem/5430)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/gold/B5430.java)
* *문자열*
* 뒤집기 함수에 따라 *poll* 또는 *pollLast* 를 해준다

## [1107 리모컨](https://www.acmicpc.net/problem/1107)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/gold/B1107.java)
* **완전 탐색**
* 숫자 버튼을 누르지 않았을 때와 눌렀을 때를 비교
* 눌렀을 시 중복 순열로 최대 7자리까지 생성

## [9935 문자열 폭발](https://www.acmicpc.net/problem/9935)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/gold/B9935.java)
* **Stack** 을 이용하여 문자를 하나씩 *push* 해주고 마지막으로 넣은 문자가 폭발 문자의 마지막 문자이면 검사를 통해 폭발 여부 확인

## [14891 톱니바퀴](https://www.acmicpc.net/problem/14891)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/gold/B14891.java)
* **DFS** 를 이용하여 양옆 톱니바퀴 이동

## [1967 트리의 지름](https://www.acmicpc.net/problem/1967)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/gold/B1967.java)
* **DFS** 를 이용하여 루트(1) 에서 가장 먼 리프노드를 찾는다
* **DFS** 를 이용하여 해당 리프노드에서 가장 먼 리프노드를 찾는다
* 인접행렬을 이용할 경우 메모리 초과가 뜨니 *인접리스트*를 이용한다

## [17471 게리맨더링](https://www.acmicpc.net/problem/17471)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/gold/B17471.java)
* **조합**을 이용하여 한 구역에 가능한 구역 조합 구하기 (*N / 2* 개수까지 구한다)
  * 6C2 나 6C4 나 똑같다
* **DFS**를 이용하여 고른 구역 조합이 인접해 있는지 체크 및 총 인구 수 구하기 

## [2666 벽장문의 이동](https://www.acmicpc.net/problem/2666)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/gold/B2666.java)
* 벽장문을 여는 방법은 2가지
* 양 끝인 경우, 제일 가까운 벽장문 처리
* 아닌 경우, 2가지를 *재귀*를 이용하여 시도

## [2636 치즈](https://www.acmicpc.net/problem/2636)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/gold/B2636.java)
* **BFS** 를 이용하여 공기인 경우 *큐*에 넣어준다
  * 다음 탐색이 공기이면 *큐*에 넣어주고
  * 치즈 이면 공기로 변환 후, 총 치즈 개수를 줄인다

## [14503 로봇 청소기](https://www.acmicpc.net/problem/14503)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/gold/B14503.java)
* 단순 구현

## [9084 동전](https://www.acmicpc.net/problem/9084)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/gold/B9084.java)
* **DP**
* 각 동전 금액으로 목적 금액까지의 경우의 수를 누적
* dp\[현재 목적 금액] += dp\[현재 목적 금액에서 현재 동전금액을 뺐을 때의 경우의 수]

## [17070 파이프 옮기기 1](https://www.acmicpc.net/problem/17070)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/gold/B17070.java)
* **DP**
* 가로, 세로, 대각선 일때의 dp 3차원 배열
  * 가로는 가로 + 대각선
  * 세로는 세로 + 대각선
  * 대각선은 가로 + 세로 + 대각선

## [2116 주사위 쌓기](https://www.acmicpc.net/problem/2116)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/gold/B2116.java)
* 맨 아래 주사위의 경우의 수 6 가지로 쌓으면서 최대 옆면의 숫자 누적

## [3107 IPv6](https://www.acmicpc.net/problem/3107)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/gold/B3107.java)
* *split* 함수는 "::" 만 기준으로만 나눈다
* *StringTokenizer* 는 "::" 일시, ":", "::" 둘다 나눈다

## [13549 숨바꼭질 3](https://www.acmicpc.net/problem/13549)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/gold/B13549.java)
* 최단 시간이기 때문에 **ProrityQueue** 이용
* 각 숫자마다 방문 배열
* 순간이동 했을 때, -1 칸 갔을 때, 1 칸 갔을 때 시도

 ## [7490 0 만들기](https://www.acmicpc.net/problem/7490)
 ### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/gold/B7490.java)
 * **중복순열**
   * 연산자의 중복 순열을 구한 후 값이 0 이면 출력
 
 ## [2225 합분해](https://www.acmicpc.net/problem/2225)
 ### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/gold/B2225.java)
 * **DP**
   * dp[K][N] = dp[K-1][N] + dp[K][N-1]

 ## [9177 단어 섞기](https://www.acmicpc.net/problem/9177)
 ### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/gold/B9177.java)
 * **DP**
 * 각 단어간 현재까지 본 인덱스 방문 배열
   * 중복 방문을 하지 않음으로서 메모리 초과 방지
 * 두 단어의 인덱스의 합은 현재 보는 최종 단어의 인덱스
   * 최종 단어의 인덱스에 도달하면 단어가 만들어진다
 
 
