//
//  [4주차]1527.swift
//  
//
//  Created by 서정원 on 4/7/24.
//

import Foundation

let inputs = readLine()!.split(separator: " ").map { Int($0)! }
var A = inputs[0]
var B = inputs[1]
var result = 0

func goldMinWater(_ num: Int) {
    if num > B {
        return
    }
    
    if A <= num && num <= B {
        result += 1
    }
    //뒤에 +4, +7 을 하면서 A 부터 B 까지의 가능한 숫자를 result 에 삽입
    goldMinWater(num * 10 + 4)
    goldMinWater(num * 10 + 7)
}

goldMinWater(4)
goldMinWater(7)

print(result)
