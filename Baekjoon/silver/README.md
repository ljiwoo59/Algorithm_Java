# Silver 1
## [2564 경비원](https://www.acmicpc.net/problem/2564)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/silver/B2564.java)
* 시계 방향, 반시계 방향으로 완전탐색
* 북서쪽 꼭짓점을 기준으로 펼치는 방법도 있다
## [16953 A->B](https://www.acmicpc.net/problem/16953)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/silver/B16953.java)
* 단순 while 문으로 구현
* BFS 를 이용하여 경우의 수를 구하는 방법도 있다

## [15900 나무 탈출](https://www.acmicpc.net/problem/15900)
### [Code : 시간초과](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/silver/B15900.java)
### [Code : from root](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/silver/B15900_2.java)
* leaf node 를 찾고 leaf 에서 부터 root 까지의 총합을 구하는 것은 시간 초과
* root 에서 **dfs** 를 통해 해당 node 까지의 총합 수를 넘겨주어 시간 줄임
   * ArrayList 대신 LinkedList 를 쓰면 시간 초과가 난다 

## [2841 외계인의 기타 연주](https://www.acmicpc.net/problem/2841)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/silver/B2841.java)
* **LinkedList 의 LinkedList** 를 구현하여 6개의 줄의 프렛 스택을 구현
* *addLast()* 와 *removeLast()* 를 이용함

# Silver 2
## [1541 잃어버린 괄호](https://www.acmicpc.net/problem/1541)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/silver/B1541.java)
* 제일 처음 '-' 기준으로 모두 빼버리면 된다

## [11053 가장 긴 증가하는 부분 수열](https://www.acmicpc.net/problem/11053)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/silver/B11053.java)
* DP 를 이용하여 현재 수 보다 작은 수가 있는지를 찾고
* 순열을 이루고 있는 작은 수를 현재 수를 포함해 담는다


# Silver 3
## [5397 키로거](https://www.acmicpc.net/problem/5397)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/silver/B5397.java)
* 최대 1,000,000의 문자열을 처리해야 하기 때문에 List 의  add, remove 함수 (평균 O(n)) 는 느리다
* Stack 의 push(), pop() 은 말단 노드에서 일어나기 때문에 O(1)
* 커서 기준 문자열 Stack 두개를 이용하여 push(), pop() 으로 처리

# Silver 4
## [1244 스위치 켜고 끄기](https://www.acmicpc.net/problem/1244)
### [Code](https://github.com/ljiwoo59/Algorithm_Java/blob/master/Baekjoon/silver/B1244.java)
* 단순 for 문과 재귀를 이용하여 구현

