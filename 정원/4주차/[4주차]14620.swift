//
//  [4주차]14620.swift
//  
//
//  Created by 서정원 on 4/7/24.
//

import Foundation
//N * N 크기의 화단      (6~10)
//꽃 하나당 그 자리와 상하좌우의 화단을 대여해야 하는데, 가장 저렴한 화단을 구매
//만약 상하좌우로 핀 꽃잎이 다른 꽃잎과 닿으면 죽는다. (닿지 않게 처리해야 된다.) 또 화단 밖으로 나가면 죽는다 (x,y) => (0,0) ~ (0,5) /

var N = Int(readLine()!)!

var graph = [[Int]]()
var visited = [[Bool]](repeating: [Bool](repeating: false, count: N), count: N)
var dx = [0, 0, -1, 1]
var dy = [1, -1, 0, 0]
var mincost = Int.max

for _ in 0..<N {        //N * N 화단 완성
    let price = readLine()!.split(separator: " ").map({ Int($0)! })
    graph.append(price)
}

func check(_ x: Int, _ y: Int) -> Bool {
    for i in 0..<4 {
        let nx = x + dx[i]
        let ny = y + dy[i]
        if nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny] {
            return false
        }
    }
    return true
}

func visitClear(_ i: Int, _ j: Int) {
    visited[i][j] = false
    for k in 0..<4 {
        let nx = i + dx[k]
        let ny = j + dy[k]
        visited[nx][ny] = false
    }
}

func price(_ i: Int, _ j: Int) -> Int {
    var result = graph[i][j]
    visited[i][j] = true
    for k in 0..<4 {
        let nx = i + dx[k]
        let ny = j + dy[k]
        result += graph[nx][ny]
        visited[nx][ny] = true
    }
    return result
}

func DFS(_ depth: Int, _ sum: Int) {
    if mincost <= sum {
        return
    }
    if depth == 3 {
        mincost = min(mincost, sum)
        return
    }
    for x in 1..<N-1 {
        for y in 1..<N-1 {
            if !visited[x][y] && check(x, y) {
                let cost = price(x, y)
                DFS(depth + 1, sum + cost)
                visitClear(x, y)
            }
        }
    }
}

// visited 배열 초기화
visited = [[Bool]](repeating: [Bool](repeating: false, count: N), count: N)

DFS(0, 0)
print(mincost)
