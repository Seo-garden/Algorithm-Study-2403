import Foundation
//백준 1182 4월 12일 금요일 오후 2시 20분 문제 읽기 -
//선언된 배열 number 에서 아무갯수의 숫자를 가져와서 합이 S 가 될 수 있는 경우의 수 출력
//백트래킹을 쓰는 이유가 사실 모든 경우의 수 만큼 for 문을 사용할 수 없어서 쓰는건데
//그걸 의식하지 못했다.
var input = readLine()!.split(separator: " ").map({ Int($0)! })
var N = input[0], S = input[1]

var count = 0
var visited = [Bool](repeating: false, count: 21)
var number = readLine()!.split(separator: " ").map({ Int($0)! })
var sum = 0

func dfs(_ depth: Int, _ start: Int){
    if sum == S && depth >= 1 { count += 1 } //배열 요소의 합이
    for i in start..<N {
        if !visited[i] {
            visited[i] = true
            sum += number[i]
            dfs(depth+1, i)
            visited[i] = false
            sum -= number[i]
        }
    }
}
dfs(0,0)
print(count)
