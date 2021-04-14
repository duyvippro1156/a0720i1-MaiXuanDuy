package DeleteIntoBinarySearchTree;

public class BST<E extends Comparable<E>> extends AbstractTree<E> {
    protected TreeNode<E> root;
    protected int size = 0;

    public BST() {
    }

    public BST(E[] objects) {
        for (int i = 0; i < objects.length; i++)
            insert(objects[i]);
    }

    @Override
    public boolean insert(E e) {
        if (root == null)
            root = createNewNode(e); /*create a new root*/
        else {
            /*locate the parent node*/
            TreeNode<E> parent = null;
            TreeNode<E> current = root;
            while (current != null) {
                if (e.compareTo(current.element) < 0) {
                    parent = current;
                    current = current.left;
                } else if (e.compareTo(current.element) > 0) {
                    parent = current;
                    current = current.right;
                } else
                    return false; /*Duplicate node not inserted*/
            }
            if (e.compareTo(parent.element) < 0)
                parent.left = createNewNode(e);
            else
                parent.right = createNewNode(e);
        }
        size++;
        return true; /*element inserted successfully*/
    }

    protected TreeNode<E> createNewNode(E e) {
        return new TreeNode<>(e);
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void Inorder() {
        Inorder(root);
    }

    protected void Inorder(TreeNode<E> root) {
        if (root == null) return;
        Inorder(root.right);
        Inorder(root.left);
        System.out.println(root.element + " ");
    }

    @Override
    public TreeNode search(TreeNode<E> root, E key) {
        if (root == null) return null;
        if (key.compareTo(root.element) < 0)
            return search(root.left, key);
        else if (key.compareTo(root.element) > 0)
            return search(root.right, key);
        else
            return root;
    }

    public TreeNode XoaGoc(TreeNode<E> root, TreeNode<E> tmp)
    {
        TreeNode R;
        if(tmp.right!=null)
        {
            root=root.left;
            R=tmp.right;
            tmp.left=null;
            tmp.right=null;
            tmp=root;
            while(tmp.right!=null)
                tmp=tmp.right;
            tmp.right=R;
        }
        else
        {
            root=tmp.right;
            tmp.right=null;
        }
        return root;
    }
    public TreeNode<E> XoaLa(TreeNode<E> root, TreeNode<E> tmp)
    {
        TreeNode<E> t=root;
        while(t.left!=tmp && t.right!=tmp)
        {
            if(t.element.compareTo(tmp.element)>0)
                t=t.left;
            else
                t=t.right;
        }
        if(t.left==tmp)
            t.left=null;
        else
            t.right=null;
        return root;
    }
    public TreeNode<E> XoaKoL(TreeNode<E> root, TreeNode<E> tmp)
    {
        TreeNode<E> t=root;
        while(t.left!=tmp && t.right!=tmp)
        {
            if(t.element.compareTo(tmp.element)>0)
                t=t.left;
            else
                t=t.right;
        }
        if(t.left==tmp)
            t.left=tmp.right;
        else
            t.right=tmp.right;
        tmp.left=null;
        tmp.right=null;
        return root;
    }
    public TreeNode<E> XoaKoR(TreeNode<E> root, TreeNode<E> tmp)
    {
        TreeNode<E> t=root;
        while(t.left!=tmp && t.right!=tmp)
        {
            if(t.element.compareTo(tmp.element)>0)
                t=t.left;
            else
                t=t.right;
        }
        if(t.left==tmp)
            t.left=tmp.left;
        else
            t.right=tmp.left;
        tmp.left=null;
        tmp.right=null;
        return root;
    }
    public TreeNode<E> XoaCoLR(TreeNode<E> root, TreeNode<E> tmp)
    {
        TreeNode<E> t=root;
        while(t.left!=tmp && t.right!=tmp)
        {
            if(t.element.compareTo(tmp.element)>0)
                t=t.left;
            else
                t=t.right;
        }
        if(t.left==tmp)
        {
            t.left=tmp.left;
            t=t.left;
        }
        else
        {
            t.right=tmp.left;
            t=t.right;
        }
        while(t.right!=null)
            t=t.right;
        t.right=tmp.right;
        tmp.left=null;
        tmp.right=null;
        return root;
    }
    TreeNode<E> Xoa(TreeNode<E> root,E info)
    {
        TreeNode<E> tmp= search(root,info);
        while(tmp!=null)
        {
            if(tmp==root)
                root=XoaGoc(root,tmp);
            else
            {
                if(tmp.left==null && tmp.right==null)
                    root=XoaLa(root,tmp);
                else
                {
                    if(tmp.left!=null && tmp.right!=null)
                        root=XoaCoLR(root,tmp);
                    else
                    {
                        if(tmp.left!=null && tmp.right==null)
                            root=XoaKoR(root,tmp);
                        else
                            root=XoaKoL(root,tmp);
                    }
                }
            }
            tmp= search(root,info);
        }
        return root;
    }
}

