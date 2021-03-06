/* Ben Eggers
 *
 * This class is an actual binary tree. Nothing fancy.
**/

public class BST<T extends Comparable<T>> extends AbstractBST<T> {

    public void remove(T data) {
        root = remove(data, root);
    }

    // Recursive helper for remove()
    private TreeNode remove(T data, TreeNode r) {
        if (r == null) {
            throw new IllegalArgumentException();
        }

        if (r.data.equals(data)) {
            if (r.right == null && r.left == null) {
                size--;
                return null;
            } else if (r.right != null && r.left != null) {
                // Get the smallest element in the right subtree
                TreeNode newValue = r.right;
                while (newValue.left != null) {
                    newValue = newValue.left;
                }
                r.data = newValue.data;
                remove(r.data, r.right);
            } else {
                size--;
                return r.left == null ? r.right : r.left;
            }
        } else if (r.data.compareTo(data) > 0) {
            r.left = remove(data, r.left);
            return r;
        } else if (r.data.compareTo(data) < 0) {
            r.right = remove(data, r.right);
            return r;
        }

        throw new RuntimeException();
    }

    public void insert(T data) {
        root = insert(data, root);
    }

    // Helper for insert()
    private TreeNode insert(T data, TreeNode r) {
        if (r == null) {
            size++;
            return new TreeNode(data);
        }

        if (r.data.compareTo(data) == 0) {
            throw new IllegalArgumentException();
        } else if (r.data.compareTo(data) > 0) {
            r.left = insert(data, r.left);
            return r;
        } else if (r.data.compareTo(data) < 0) {
            r.right = insert(data, r.right);
            return r;
        }

        // We should never get here
        throw new RuntimeException();
    }
}
