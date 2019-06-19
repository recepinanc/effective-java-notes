// Rewritten an *almost* ready to run Flyweight Pattern sample code in java
// The original source code https://refactoring.guru/design-patterns/flyweight

class Tree
{
    private int x, y;
    private TreeType treeType;

    public Tree(int x, int y, TreeType treeType)
    {
        this.x = x;
        this.y = y;
        this.treeType = treeType;
    }
}

class TreeType
{
    private int numberOfBranches;
    private String color;
    private boolean isExported;

    public TreeType(int numberOfBranches, String color, boolean isExported)
    {
        this.numberOfBranches = numberOfBranches;
        this.color = color;
        this.isExported = isExported;
    }

    public void loseLeaves()
    {
        System.out.println("Dropping my leaves as " + this.toString());
    }

    public int getNumberOfBranches()
    {
        return numberOfBranches;
    }

    public String getColor()
    {
        return color;
    }

    public boolean isExported()
    {
        return isExported;
    }
}

class TreeFactory {
    public static ArrayList<TreeType> treeTypes = new ArrayList<>();
    public static TreeType getTreeType(int numberOfBranches, String color, boolean isExported) {
        TreeType treeType = treeTypes.find(numberOfBranches, color, isExported);

        if (treeType == null) {
            treeType = new TreeType(numberOfBranches, color, isExported);
            treeTypes.add(treeType);
        }

        return treeType;
    }

    private TreeType find(int numberOfBranches, String color, boolean isExported) {
        for (TreeType treeType : treeTypes) {
            if (treeType.getNumberOfBranches() == numberOfBranches && treeType.getColor().equals(color) && treeType.isExported() == isExported)
            return treeType;
        }
        return null;
    }

}

class Forest
{
    private ArrayList<Tree> trees;

    public void plantTree(int x, int y, int numberOfBranches, String color, boolean isExported) {
        TreeType treeType = TreeFactory.getTreeType(numberOfBranches, color, isExported);
        Tree tree = new Tree(x, y, treeType);
        trees.add(tree);
        System.out.println("Number of trees in the forest: " + trees.size());
    }
}
