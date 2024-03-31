//
//  1012.swift
//  
//
//  Created by 서정원 on 3/29/24.
//
//백준 1012
import Foundation

var t = Int(readLine()!)!

var count = 0
for _ in 0..<t {
    let input = readLine()!.split(separator: " ").map({ Int($0)!})
    let m = input[0], n = input[1], k = input[2]
    
    var graph = [[Int]](repeating: [Int](repeating: 0, count: n), count: m)

    for _ in 1...k {
        let placeXY = readLine()!.split(separator: " ").map({ Int($0)!})
        let x = placeXY[0]
        let y = placeXY[1]
        graph[x][y] = 1
    }

    // 입력값은 다 받았고
    // DFS or BFS 돌려서 배추흰주렁이를 놓을 공간을 찾으면 된다.

    func dfs(_ x: Int, _ y: Int) {
        if x < 0 || y < 0 || x >= m || y >= n { return }
        if graph[x][y] == 1 {
            graph[x][y] = 0     //방문처리를 하기 위함
            dfs(x-1, y)         //좌
            dfs(x+1, y)         //우
            dfs(x, y-1)         //상
            dfs(x, y+1)         //하
        }
    }
    for i in 0..<m {
        for j in 0..<n {
            if graph[i][j] == 1 {
                dfs(i,j)
                count += 1
            }
        }
    }
    dfs(m, n)
    print(count)
    count = 0
}
