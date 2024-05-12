//4월 18일 목요일 오후 3시 시작
//기차는 20개의 일렬로 된 좌석 한 좌석에 한사람만
//기차의 번호를 1 ~ N 번으로 매길 때, 기차에 대한 M 개의 명령
//1 i x : i번째 기차에(1 ≤ i ≤ N) x번째 좌석에(1 ≤ x ≤ 20) 사람을 태워라. 이미 사람이 타있다면 , 아무런 행동을 하지 않는다.
//2 i x : i번째 기차에 x번째 좌석에 앉은 사람은 하차한다. 만약 아무도 그자리에 앉아있지 않았다면, 아무런 행동을 하지 않는다.
//3 i : i번째 기차에 앉아있는 승객들이 모두 한칸씩 뒤로간다. k번째 앉은 사람은 k+1번째로 이동하여 앉는다. 만약 20번째 자리에 사람이 앉아있었다면 그 사람은 이 명령 후에 하차한다. (1 << i)
//4 i : i번째 기차에 앉아있는 승객들이 모두 한칸씩 앞으로간다. k번째 앉은 사람은 k-1 번째 자리로 이동하여 앉는다. 만약 1번째 자리에 사람이 앉아있었다면 그 사람은 이 명령 후에 하차한다. (1 >> i)
//M 번의 명령을 수행한 후에 1번째 기차부터 한 기차씩 은하수를 건너는 조건이 있다.
//기차에 아무도 없어도 출발하는 케이스가 있다.
//이후 두 번째 줄부터 M+1번째 줄까지 각 줄에 명령이 주어진다.
//5 5       출력 : 2
//1 1 1
//1 1 2
//1 2 2
//1 2 3
//3 1

import Foundation

let NM = readLine()!.split(separator: " ").map { Int($0)! }
let N = NM[0]
let M = NM[1]

var train = [Int](repeating: 0, count: N)

for _ in 0..<M {
    let op = readLine()!.split(separator: " ").map { Int($0)! }
    if op[0] == 1 {
        let i = op[1] - 1       //i 열차번호인데
        let x = op[2] - 1       //x 좌석번호
        train[i] |= 1 << x      //train[i] 에 x 원소를 추가
    } else if op[0] == 2 {
        let i = op[1] - 1       //i 열차번호
        let x = op[2] - 1       //x 좌석번호
        train[i] &= ~(1 << x)   //train[i] 에 x 원소를 삭제
    } else if op[0] == 3 {
        let i = op[1] - 1       //i 열차번호
        train[i] <<= 1          //한칸씩 뒤로
        train[i] &= ~(1 << 20)  //비트가 넘어가는 걸 방지
    } else if op[0] == 4 {
        let i = op[1] - 1       //i 열차번호
        train[i] >>= 1          //한칸씩 앞으로
    }
}

let uniqueTrain = Set(train)
print(uniqueTrain.count)
