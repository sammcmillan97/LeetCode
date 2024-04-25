public class GasStation {
    // public int canCompleteCircuit(int[] gas, int[] cost) {
    //     int[] course = new int[gas.length];
    //     int sum = 0;
    //     for(int i = 0; i < gas.length; i++) {
    //         course[i] = gas[i] - cost[i];
    //         sum+= course[i];
    //     }
    //     if (sum < 0) {
    //         return -1;
    //     }
    //     for(int i = 0; i < course.length; i++) {
    //         int petrol = 0;
    //         for(int j = 0; j < course.length; j++) {
    //             int index = (i + j) % course.length;
    //             if (petrol < 0) {
    //                 break;
    //             }
    //             petrol+= course[index];
    //         }
    //         if (petrol >= 0) {
    //             return i;
    //         }
    //     }
    //     return -1;
    // }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sGas = 0, sCost = 0, res = 0, total = 0;
        for (int i = 0; i < gas.length; i++) {
            sGas += gas[i];
            sCost += cost[i];
        }
        if (sGas < sCost) return -1;
        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            System.out.println(total);
            if (total < 0) {
                total = 0;
                res = i + 1;
                System.out.println(res);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        GasStation s = new GasStation();
        int[] cost = {3, 4, 5, 1, 2};
        int[] gas = {1, 2, 3, 4, 5};
        System.out.println(s.canCompleteCircuit(gas, cost));
    }
}
