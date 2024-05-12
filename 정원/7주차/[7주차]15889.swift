import Foundation

var N = Int(readLine()!)!
var coordinates = readLine()!.split(separator: " ").map({ Int($0)! })
var max_range = 0
if N > 1 {
    let maxRangeCoordinates = readLine()!.split(separator: " ").map({ Int($0)! })
    
    for i in 0..<N-1 {
        max_range = max(max_range, coordinates[i] + maxRangeCoordinates[i])
        if max_range < coordinates[i+1] {
            print("엄마 나 전역 늦어질 것 같아")
            exit(0)
        }
    }
}
print("권병장님, 중대장님이 찾으십니다")
