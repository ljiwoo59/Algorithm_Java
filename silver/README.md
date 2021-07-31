# Silver 1
## [2564 경비원](https://www.acmicpc.net/problem/2564)
* 시계 방향, 반시계 방향으로 완전탐색
* 북서쪽 꼭짓점을 기준으로 펼치는 방법도 있다
## [16953 A->B](https://www.acmicpc.net/problem/16953)
* 단순 while 문으로 구현
* BFS 를 이용하여 경우의 수를 구하는 방법도 있다
# Silver 2
## [1541 잃어버린 괄호](https://www.acmicpc.net/problem/1541)
* 제일 처음 '-' 기준으로 모두 빼버리면 된다
# Silver 3
## [5397 키로거](https://www.acmicpc.net/problem/5397)
* 최대 1,000,000의 문자열을 처리해야 하기 때문에 List 의  add, remove 함수 (평균 O(n)) 는 느리다
* Stack 의 push(), pop() 은 말단 노드에서 일어나기 때문에 O(1)
* 커서 기준 문자열 Stack 두개를 이용하여 push(), pop() 으로 처리
