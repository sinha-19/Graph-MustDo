import java.util.*;
public class AccountsMerge {
    /*
     * Problem: Merge accounts by shared emails
     * Approach: DSU on emails; group and collect sorted
     * Time: O(n log n), Space: O(n)
     */
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> parent = new HashMap<>();
        Map<String, String> owner = new HashMap<>();
        for (List<String> a : accounts) {
            String name = a.get(0);
            for (int i = 1; i < a.size(); i++) {
                String email = a.get(i);
                owner.put(email, name);
                parent.putIfAbsent(email, email);
            }
        }
        DSUExt ds = new DSUExt(parent);
        for (List<String> a : accounts) {
            String first = a.get(1);
            for (int i = 2; i < a.size(); i++) ds.union(first, a.get(i));
        }
        Map<String, TreeSet<String>> groups = new HashMap<>();
        for (String email : parent.keySet()) {
            String root = ds.find(email);
            groups.computeIfAbsent(root, k -> new TreeSet<>()).add(email);
        }
        List<List<String>> res = new ArrayList<>();
        for (String root : groups.keySet()) {
            List<String> merged = new ArrayList<>();
            merged.add(owner.get(root));
            merged.addAll(groups.get(root));
            res.add(merged);
        }
        return res;
    }
}
class DSUExt {
    Map<String, String> parent;
    public DSUExt(Map<String, String> p) { parent = p; }
    public String find(String x) {
        if (!parent.get(x).equals(x))
            parent.put(x, find(parent.get(x)));
        return parent.get(x);
    }
    public void union(String a, String b) {
        a = find(a); b = find(b);
        if (!a.equals(b)) parent.put(a, b);
    }
}
