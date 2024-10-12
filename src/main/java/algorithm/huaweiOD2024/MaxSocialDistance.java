package algorithm.huaweiOD2024;

import java.util.ArrayList;
import java.util.List;

/**
 * 最大社交距离
 * https://fcqian.blog.csdn.net/article/details/128160300
 * @author hason
 * @since 2024/5/26 20:44
 */
public class MaxSocialDistance {

    /**
     * 返回最后一个员工的位置
     */
    public int findLastStaffSeatId(int seatNum, int[] seatOrLeave) {
        int seatId = -1;
        // 记录已入座员工的座位号
        List<Integer> staffSeatIds = new ArrayList<>(seatOrLeave.length);

        for (int i = 0; i < seatOrLeave.length; i++) {
            int flag = seatOrLeave[i];
            // 两种情况
            // 1.如果小于0 则代表离开
            if (flag < 0) {
                int leaveSeatId = -flag;
                staffSeatIds.remove(leaveSeatId);
                continue;
            }

            // 2.如果大于0 代表入座 此时分三种请款
            // 2.1 如果staffSeatIds.size()为0 说明无人入座 直接从第一个座开始即可
            // 2.2 如果staffSeatIds.size()为1 说明只有一人入座，那么保持最大社交距离，就坐最后一座
            // 2.3 如果staffSeatIds.size()>1 说明取中点入座（此时要考虑边界情况）
            if (staffSeatIds.size() == 0) {
                staffSeatIds.add(flag);
            } else if (staffSeatIds.size() > 0) {
                staffSeatIds.add(seatNum - 1, flag);
            } else {
                // 最大社交距离
                int bestDis = -1;
                // 最大社交距离的座位号
                int bestSeatId = -1;
                int left = staffSeatIds.get(0);
                // 遍历已经入座的人的位置 找到边界
                for (int j = 1; j < staffSeatIds.size(); j++) {
                    int right = staffSeatIds.get(j);
                    int dis = right - left - 1;
                    if (dis > 0) {
                        // 分奇偶数
                        int curDis = dis / 2 - (dis % 2 == 0 ? 1 : 0);
                        int curSeatId = left + curDis + 1;
                        if (curDis > bestDis) {
                            bestDis = curDis;
                            bestSeatId = curSeatId;
                        }
                    }
                    left = right;
                }
                // 特殊情况10001000 此时最后一个座位没人（已经离开）
                if (staffSeatIds.get(staffSeatIds.size() - 1) < seatNum - 1) {
                    int curDis = seatNum - 1 - staffSeatIds.get(staffSeatIds.size() - 1) - 1;
                    int curSeatId = seatNum - 1;
                    if (curDis > bestDis) {
                        bestSeatId = curSeatId;
                    }
                }
                if (bestSeatId > 0) {
                    staffSeatIds.add(bestSeatId);
                    // 升序
                    staffSeatIds.sort((a, b) -> (a - b));
                }
                seatId = bestSeatId;
            }
        }

        return seatId;
    }
}
