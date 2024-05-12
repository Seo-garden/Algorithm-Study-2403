import Foundation
//백트래킹이란, 모든 경우의 수를 확인해야 할 때 주로 사용한다.
//순열 : M 개의 숫자중 N 개를 뽑아서 순서에 맞게 배열하는 것
//N 개의 숫자를 뽑아서 사용할 때 for 문을 더 이상 늘려서 사용할 수가 없다. 그래서 백트래킹을 사용하는 거다.

//백준 15649
//1. 아이디어 : 백트래킹 재귀함수 안에서, for문을 돌면서 숫자 선택(방문여부 확인) / 재귀함수에서 M 개를 선택할 경우 print()
//2. 시간복잡도 : N! > 가능
//3. 자료구조 : 결과 Int, 방문여부 [Bool]
var input = readLine()!.split(separator: " ").map({ Int($0)! })
var N = input[0], M = input[1]

var result = [Int]()
var visited = [Bool](repeating: false, count: N+1)

func dfs(_ depth: Int){
    if depth == M {
        print(result.map({ String($0) }).joined(separator: " "))
        return
    }
    for i in 1..<N+1 {
        if visited[i] == false {
            visited[i] = true
            result.append(i)
            dfs(depth+1)
            visited[i] = false    //방문여부를 되돌리고,
            result.removeLast()   //빠져나오면서 제거
        }
    }
}
dfs(0)
