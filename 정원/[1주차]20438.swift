//
//  [1주차]20438.swift
//  Algorithm
//
//  Created by 서정원 on 3/8/24.
//
//
//코로나 바이러스로 인해 H 대학은 비대면 강의를 실시하고 있다. 조교를 담당하게 된 지환이는 출석체크 방식을 바꾸려고 한다.
//학생들은 접속 순서대로 3번부터 N + 2번까지 입장 번호를 받게 된다.
//지환이가 한 학생에게 출석 코드를 보내게 되면, 해당 학생은 본인의 입장 번호의 배수인 학생들에게 출석 코드를 보내어 해당 강의의 출석을 할 수 있게끔 한다.
//하지만, K명의 졸고 있는 학생들은 출석 코드를 제출하지 않고, 다른 학생들에게 보내지 않는다.
//지환이는 무작위로 한 명의 학생에게 출석 코드를 보내는 행위를 Q번 반복한 뒤, 출석부 정리를 위해 특정 구간의 입장 번호를 받은 학생들 중에서 출석이 되지 않은 학생들의 수를 구하고 싶다.
//많은 인원을 담당해서 바쁜 지환이를 위해 프로그램을 만들어주자!
//1번째 줄에 학생의 수 N, 졸고 있는 학생의 수 K, 지환이가 출석 코드를 보낼 학생의 수 Q, 주어질 구간의 수 M이 주어진다. (1 ≤ K, Q ≤ N ≤ 5,000, 1 ≤ M ≤ 50,000)
//2번째 줄과 3번째 줄에 각각 K명의 졸고 있는 학생의 입장 번호들과 Q명의 출석 코드를 받을 학생의 입장 번호들이 주어진다.
//4번째 줄부터 M개의 줄 동안 구간의 범위 S, E가 공백을 사이에 두고 주어진다. (3 ≤ S < E ≤ N + 2)
//10 1 3 1
//7
//3 5 7
//3 12
import Foundation
//처음 했던 실수
//1. 배열을 생성할 때 생성과 동시에 출석 번호를 넣으려고 했다. 사실 이게 중요한게 아니라 출석하지 않은 학생 수를 구하는거라, 번호를 넣을 필요는 없다. 여기서부터 생각이 꼬였다. (문제이해를 바로 하지 못했다.)
//졸고 있는 학생의 배열을 선언 (Bool or Int)
//출석코드를 받지 못한 학생의 배열을 구해야 한다. (누적 합)⭐️
//조는 학생의 배열(졸고 있다고 판단되면 배열에 삽입을 해야 된다.)
let input = readLine()!.split(separator: " ").map { Int(String($0))!}       //처음 입력 할 때 학생 수, 졸거나 자는 학생, 출석코드를 보낼 학생의 수, 주어질 구간의 수 입력
let n = input[0] + 2, k = input[1], q = input[2], m = input[3]              //각 변수에 할당을 한다.
var students = [Int](repeating: 0, count: n + 1)                       //출석하지 않은 학생 정의     repeating: 반복할 데이터, count : 횟수
var prefixSum = [Int](repeating: 0, count: n + 1)                           //코드를 받지 못한 학생의 누적
// 조는 학생의 입장 번호
var sleeping = Set<Int>()                                                   //조는 학생의 Set 선언

let sleepArr = readLine()!.split(separator: " ").map { Int(String($0))! }   //졸고 있는 학생의 입장번호를 입력(무작위)
let code = readLine()!.split(separator: " ").map { Int(String($0))! }       //출석 코드를 받을 학생의 입장 번호

for i in sleepArr {                                                         //졸고 있는 학생을 조는 학생의 배열에 넣는다.
    sleeping.insert(i)
}

for i in code {     //졸고있으면 멈추는 줄 알았는데, 그게 아니였다.
    if sleeping.contains(i){ continue }     //출석 코드를 입력 후 졸고 있는 학생이 있다면 다음 배수로 넘어간다.
    var j = 1
    while i * j <= n {          //내가 입력한 학생의 수보다 작거나 같아질 때까지 반복하는데,
        if !sleeping.contains(i * j){
            students[i * j] = 1          //졸고 있는 학생의 배수는 당연히 출석번호를 받지 못했다.
        }
        j += 1          //입력한 수의 j += 1 이 배수를 가리킨다.
    }
}

for i in 3 ... n {      //3부터 입력한 수까지
    prefixSum[i] += prefixSum[i - 1]        //현재 까지의 누적된 값을 넣는다.
    if students[i] == 0 {       //해당 배열 자리에 0, 즉 출석한 학생이 없으면
        prefixSum[i] += 1       //누적 합을 증가
    }
}
var ans = ""
for _ in 0 ..< m {
    let range = readLine()!.split(separator: " ").map { Int(String($0))!}
    ans += "\(prefixSum[range[1]] - prefixSum[range[0] - 1])\n"     //range[1]이 끝지점, range[0] - 1 처음지점으로, 사이의 쿼리 범위 내의 합을 추가
}
print(ans)
