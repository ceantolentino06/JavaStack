public class ProjectTest {
    public static void main(String[] args) {
        Project project1 = new Project("Miranda", "Movie review site");
        project1.elevatorPitch();
        System.out.println(project1.getProjectName());
        System.out.println(project1.getProjectDesc());
        project1.setProjectName("New Name");
        project1.setProjectDesc("Test");
        System.out.println(project1.getProjectName());
        System.out.println(project1.getProjectDesc());
    }
}