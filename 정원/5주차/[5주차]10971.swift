//
//  [5주차]10971.swift
//  
//
//  Created by 서정원 on 5/11/24.
//

import Foundation

//백준 10971 - 4월 14일 오후 1시 36분 시작

//1부터 N 번 까지의 번호가 매겨져 있는 도시, 도시 사이에 길이 있다.(없을수도 있다.)
//한번 갔던 도시는 재방문할 수 없다.
//각 도시간에 이동하는 비용 W[[i][j]] --> 도시 i 부터 도시 j 로 가기 위한 비용, 비용은 대칭적이지 않다. 즉, i-> j 와 j-> i 는 다를 수 있다. 도시간의 비용은 양의 정수

import Foundation

var N = Int(readLine()!)!

var visited: [Bool] = Array(repeating: false, count: N)
var W: [[Int]] = Array(repeating: [], count: N)
var result = Int.max
var sum = 0

for i in 0..<N {
    let input = readLine()!.split(separator: " ").map({ Int($0)! })
    W[i] = input
}

func dfs(_ depth: Int, _ now: Int, _ start: Int){
    if depth == N && now == start { //다 돌고 현재노드가 시작노드
        result = min(result, sum)
        return
    }
    for i in 0..<N {
        if !visited[i] && W[now][i] > 0 {       //방문하지 않았고, 다음 노드가 갈수있는곳
            visited[i] = true
            sum += W[now][i]
            if sum <= result {//이미 찾은 최소 경로보다 길이 합이 더 긴 경로만 탐색
                dfs(depth+1, i, start)
            }
            visited[i] = false
            sum -= W[now][i]
        }
    }
    
}

dfs(0, 0, 0)
print(result)
