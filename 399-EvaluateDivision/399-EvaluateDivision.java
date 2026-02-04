// Last updated: 2/4/2026, 12:57:07 PM
import java.util.*;

class Solution {
    public double[] calcEquation(
            List<List<String>> equations,
            double[] values,
            List<List<String>> queries) {

      
        Map<String, Map<String, Double>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double val = values[i];

            graph.putIfAbsent(a, new HashMap<>());
            graph.putIfAbsent(b, new HashMap<>());

            graph.get(a).put(b, val);
            graph.get(b).put(a, 1.0 / val);
        }

        double[] result = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            String src = queries.get(i).get(0);
            String dst = queries.get(i).get(1);

            if (!graph.containsKey(src) || !graph.containsKey(dst)) {
                result[i] = -1.0;
            } else if (src.equals(dst)) {
                result[i] = 1.0;
            } else {
                result[i] = dfs(src, dst, 1.0, new HashSet<>(), graph);
            }
        }

        return result;
    }

    private double dfs(String curr, String target, double product,
                       Set<String> visited,
                       Map<String, Map<String, Double>> graph) {

        if (curr.equals(target)) return product;

        visited.add(curr);

        for (Map.Entry<String, Double> next : graph.get(curr).entrySet()) {
            if (!visited.contains(next.getKey())) {
                double res = dfs(
                        next.getKey(),
                        target,
                        product * next.getValue(),
                        visited,
                        graph
                );
                if (res != -1.0) return res;
            }
        }

        return -1.0;
    }
}