//
//  2606.swift
//  
//
//  Created by 서정원 on 3/16/24.
//

import Foundation
var computer = Int(readLine()!)!
var M = Int(readLine()!)!
var graph = [[Int]](repeating: [], count: computer+1)
var visited = [Bool](repeating: false, count: computer+1)
var count = 0
for _ in 0..<M {
    let inputArr = readLine()!.split(separator: " ").map { Int($0)! }
    var u = inputArr[0], v = inputArr[1]
    graph[u].append(v)
    graph[v].append(u)
}
func DFS(node: Int) {
    visited[node] = true
    for nextnode in graph[node] {
        if !visited[nextnode] {
            DFS(node: nextnode)
            count+=1
        }
    }
}

DFS(node: 1)
print(count)      //1번 컴퓨터는 감염됐다
