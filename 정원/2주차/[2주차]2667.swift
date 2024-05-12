//
//  2667.swift
//  
//
//  Created by 서정원 on 3/24/24.
//

import Foundation
let n = Int(readLine()!)!
var map = [[Int]]()
var count = 0       //단지개수
var block = [Int]() //단지내 집의 개수

for _ in 0..<n {
    map.append(Array(readLine()!.map({Int(String($0))!})))
}

// 메인 실행
for i in 0..<n {
    for j in 0..<n {
        if map[i][j] == 1 {
            count = 0 // count 초기화 단지넓이 초기화
            dfs(i, j) // dfs 호출
            block.append(count) // block 배열에 방금 구한 단지 크기 추가
        }
    }
}
// dfs 함수
func dfs(_ x: Int, _ y: Int) {
    if x < 0 || y < 0 || x >= n || y >= n || map[x][y] == 0 { return } // 예외
    
    count += 1 // 단지 넓이 누적
    map[x][y] = 0 // 이미 체크한 자리는 0으로 바꿔서 중복 검사 피해주기
    
    // 재귀 호출 좌우상하 체크
    dfs(x+1, y)
    dfs(x-1, y)
    dfs(x, y+1)
    dfs(x, y-1)
}


print(block.count)
print(block.sorted().map({String($0)}).joined(separator: "\n"))     //문자열 변환 후 줄바꿈하고 출력
