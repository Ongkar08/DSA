class Solution {
    public int maxEvents(int[][] events){
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i = 0, n = events.length, day =1, count = 0;
         int lastDay = Arrays.stream(events).mapToInt(e -> e[1]).max().getAsInt();
         while (day <= lastDay && (i < n || !pq.isEmpty())) {
            if (pq.isEmpty() && i < n) {
                day = Math.max(day, events[i][0]);
            }
            while (!pq.isEmpty() && pq.peek() < day) {
                pq.poll();
            }
            while (i < n && events[i][0] == day) {
                pq.offer(events[i][1]);
                i++;
            }
            if (!pq.isEmpty()) {
                pq.poll();
                count++;
            }
            day++;
        }
        return count;
    }

    }