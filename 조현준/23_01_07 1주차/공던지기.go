package _023_01_07

func solution(numbers []int, k int) int {
	//배열 인덱스는 0번부터 시작하닌까 0으로 초기화
	idx := 0

	//k 번째 던질시 몇칸을 이동하는지 인덱스 구한다.
	for i := 1; i <= k-1; i++ {
		//2칸씩 이동하므로 1번 던질때마다 +2씩 해준다.
		idx += 2
	}
	//총 이동 인덱스를 배열길이로 나눈 나머지 값이 그사람이 k번째 던질 사람.
	resultIdx := idx % len(numbers)

	return numbers[resultIdx]
}
