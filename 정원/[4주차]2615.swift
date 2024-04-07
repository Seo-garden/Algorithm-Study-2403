//
//  [4주차]2615.swift
//  
//
//  Created by 서정원 on 4/7/24.
//

import Foundation

//이해를 못해서 나중에 또 봐야겠다.
//https://wooono.tistory.com/623 - 참고
var graph = [[Int]]()
for _ in 0..<19 {
    let input = readLine()!.split(separator: " ").map({ Int($0)! })
    graph.append(input)
}
var visited = false
//연속된 다섯 개의 바둑알 중 가장 왼쪽에 있는 바둑알의 좌표를 출력해야하므로, 4가지 방향
// → ↓ ↘ ↗
var dx = [0, 1, 1, -1]
var dy = [1, 0, 1, 1]
var count = 0
func 5mok(){
    for x in 0..<19 {
        for y in 0..<19 {
            if graph[x][y] != 0 {       //바둑알이 놓아져 있다면
                let focus = graph[x][y] //바둑알 번호를 넣고,
                for i in 0..<4 {        //상하좌우 탐색
                    count = 1
                    var nx = dx[i] + x
                    var ny = dy[i] + y
                    
                    while 0 <= nx && nx < 19 && 0 <= ny && ny < 19 && graph[nx][ny] == focus {      //동일한 바둑 번호가 있다면
                        count += 1
                        if count == 5 {     //6목 체크
                            //첫 바둑알을 놓은 방향 이전에 바둑알이 더 있는지
                            if 0 <= x - dx[i] && x - dx[i] < 19 && 0 <= y - dy[i] && y - dy[i] < 19 && graph[x - dx[i]][y - dy[i]] == focus { break }
                            //마지막 바둑알을 놓은 방향 이후에 바둑알이 하나 더 있는지 확인
                            if 0 <= nx + dx[i] && nx + dx[i] < 19 && 0 <= ny + dy[i] && ny + dy[i] < 19 && graph[nx + dx[i]][ny + dy[i]] == focus { break }
                            //육목이 아니면 성공
                            print(focus)
                            print(x + 1, y + 1)
                            visited = true
                            
                            return
                        }
                        //탐색 방향으로 위치 업데이트
                        nx += dx[i]
                        ny += dy[i]
                    }
                }
            }
        }
    }
    if visited == false {           //오목을 찾지 못했다면
        print(0)
        return
    }
}
5mok()
