import java.util.Arrays;

class Solution {
    
    static int M, N;

    public boolean solution(int[][] key, int[][] lock) {
        M = key.length;
        N = lock.length;

        // 4번 회전 (0도, 90도, 180도, 270도)
        for (int rotation = 0; rotation < 4; rotation++) {
            // 패딩된 지도 위에서 열쇠를 한 칸씩 이동 (시작점 좌표 i, j)
            // 안전하게 N * 3 크기의 공간에서 이동시킵니다.
            for (int i = 0; i < N * 2; i++) {
                for (int j = 0; j < N * 2; j++) {
                    
                    // 1. 큰 지도 생성 및 중앙에 자물쇠 배치
                    int[][] map = new int[N * 3][N * 3];
                    for (int x = 0; x < N; x++) {
                        for (int y = 0; y < N; y++) {
                            map[x + N][y + N] = lock[x][y];
                        }
                    }

                    // 2. 해당 위치(i, j)에 열쇠 더하기
                    matchKey(map, key, i, j);

                    // 3. 자물쇠 영역이 모두 1(홈이 전부 돌기로 채워짐)인지 확인
                    if (checkLock(map)) {
                        return true;
                    }
                }
            }
            // 열쇠 회전
            key = rotate(key);
        }

        return false;
    } // end of solution

    // 열쇠를 시계 방향으로 90도 회전하는 함수
    static int[][] rotate(int[][] key) {
        int[][] rotated = new int[M][M];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                rotated[j][M - 1 - i] = key[i][j];
            }
        }
        return rotated;
    }

    // 확장된 지도에 열쇠 값을 더해주는 함수
    static void matchKey(int[][] map, int[][] key, int startX, int startY) {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                map[startX + i][startY + j] += key[i][j];
            }
        }
    }

    // 자물쇠 부분이 전부 정확히 1인지 검사하는 함수
    static boolean checkLock(int[][] map) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 돌기와 돌기가 만나서 2가 되거나, 홈이 채워지지 않아 0이면 실패
                if (map[i + N][j + N] != 1) {
                    return false;
                }
            }
        }
        return true;
    }
}