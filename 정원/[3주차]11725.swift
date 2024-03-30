//
//  11725.swift
//  
//
//  Created by 서정원 on 3/30/24.
//

//백준 11725
import Foundation
var input = Int(readLine()!)!
var graph = [[Int]](repeating: [Int](repeating: 0, count: 0), count: input + 1)

var visited = [Int](repeating: 0, count: input + 1)

for _ in 0..<input-1 {
    let node = readLine()!.split(separator: " ").map({ Int($0)! })
    let n1 = node[0], n2 = node[1]
    graph[n1].append(n2)
    graph[n2].append(n1)
}

func dfs(node : Int = 1) {      //트리의 노드가 1이라고 지정
    for nextnode in graph[node] {
        if visited[nextnode] == 0 {         //다음 노드가 아직 방문이 되지 않은 경우
            visited[nextnode] = node        //다음 노드를 현재 노드의 자식노드로 표시
            dfs(node: nextnode)
        }
    }
}

dfs()

for i in 2...input {
    print(visited[i])
}
