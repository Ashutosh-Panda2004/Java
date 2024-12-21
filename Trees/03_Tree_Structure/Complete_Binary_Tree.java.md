A **complete binary tree** is a type of binary tree that satisfies the following two conditions:

1. **All levels are fully filled** except possibly the last level.
   - This means that all nodes at every level, except the last one, must have two children.
  
2. **All nodes are as far left as possible** at the last level.
   - If the last level isn't fully filled, the nodes should be positioned starting from the left side, without any gaps between them.

### Characteristics:
- In a complete binary tree, all levels are completely filled except the last one, which may have nodes only on the left side.
- The last level may not be completely filled, but it must be filled from left to right.
  
### Example:

**Complete Binary Tree:**
```
         1
       /   \
      2     3
     / \   /
    4   5 6
```
- Here, all levels except the last are completely filled.
- The last level has nodes 4, 5, and 6, and it is filled from left to right.

**Not a Complete Binary Tree:**
```
         1
       /   \
      2     3
     / \     \
    4   5     6
```
- This is not a complete binary tree because the node `6` is placed on the right side of the last level, while node `3` has no left child, violating the rule that nodes at the last level should be filled from left to right.

In summary, a complete binary tree ensures that all levels are filled except possibly the last, and the last level, if not completely filled, should have nodes aligned to the left.