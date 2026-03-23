import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Main {
    public JPanel mainPanel;
    private JPanel cardPanel;

    private JButton btnSearch;
    private JButton btnGoAdd;

    private JList<String> recipeList;
    private JTextArea txtRecipeDetails;
    private JButton btnBackFromSearch;

    private JTextField txtAddName;
    private JTextArea txtAddSteps;
    private JButton btnSaveRecipe;
    private JButton btnBackFromAdd;

    private DefaultListModel<String> listModel;




    public Main() {
        RecipeCheck RecipeCheck = new RecipeCheck();
        RecipeAdd RecipeAdd = new RecipeAdd();
        listModel = new DefaultListModel<>();
        if (recipeList != null) {
            recipeList.setModel(listModel);
            recipeList.setOpaque(false);
        }

        if (txtRecipeDetails != null) {
            txtRecipeDetails.setOpaque(false);
        }


        if (txtAddSteps != null) {
            txtAddSteps.setOpaque(false);
        }

        if (mainPanel != null) {
            makeScrollPanesTransparent(mainPanel);
        }

        if (btnSearch != null) {
            btnSearch.addActionListener(e -> {

                if (listModel != null) {
                    listModel.clear();
                    String[] Menu = null;
                    try {
                        Menu = RecipeCheck.RecipeList().split(",");
                    for(int i =0;i<RecipeCheck.RecipeAmount();i++){
                        listModel.addElement(Menu[i]);
                    }
                    } catch (FileNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                if (txtRecipeDetails != null) txtRecipeDetails.setText("Click a menu on the left to view the recipe.");
                switchCard("SearchCard");
            });
        }

        if (btnGoAdd != null) {
            btnGoAdd.addActionListener(e -> switchCard("AddCard"));
        }

        if (recipeList != null) {
            recipeList.addListSelectionListener(e -> {
                if (!e.getValueIsAdjusting()) {
                    String selected = recipeList.getSelectedValue();
                    if (selected != null && txtRecipeDetails != null) {
                        txtRecipeDetails.setText(RecipeCheck.RecipeStep(selected));
                    }
                }
            });
        }

        if (btnBackFromSearch != null) btnBackFromSearch.addActionListener(e -> switchCard("HomeCard"));
        if (btnBackFromAdd != null) btnBackFromAdd.addActionListener(e -> switchCard("HomeCard"));

        if (btnSaveRecipe != null) {
            btnSaveRecipe.addActionListener(e -> {
                if (txtAddName != null && txtAddName.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(mainPanel, "Please enter a recipe name before saving.");
                    return;
                }
                try {
                    if(RecipeAdd.RecipeCheck(txtAddName.getText())){
                        JOptionPane.showMessageDialog(mainPanel, "Already have this recipe");
                        return;
                    }
                    RecipeAdd.RecipeCreate(txtAddName.getText());
                    RecipeAdd.RecipeStepWrite(txtAddName.getText(),txtAddSteps.getText());
                    RecipeAdd.RecipeListAdd(txtAddName.getText());


                JOptionPane.showMessageDialog(mainPanel, "Recipe added successfully!");
                if (txtAddName != null) txtAddName.setText("");

                if (txtAddSteps != null) txtAddSteps.setText("");
                switchCard("HomeCard");
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });
        }
    }

    private void switchCard(String cardName) {
        if (cardPanel != null && cardPanel.getLayout() instanceof CardLayout) {
            CardLayout cl = (CardLayout) cardPanel.getLayout();
            cl.show(cardPanel, cardName);
        }
    }

    private void makeScrollPanesTransparent(Container container) {
        for (Component component : container.getComponents()) {
            if (component instanceof JScrollPane scrollPane) {
                scrollPane.setOpaque(false);
                scrollPane.getViewport().setOpaque(false);
            }

            if (component instanceof JComponent jComponent) {
                jComponent.setOpaque(false);
            }

            if (component instanceof Container childContainer) {
                makeScrollPanesTransparent(childContainer);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Recipe Management Studio");
            Main app = new Main();


            if (app.mainPanel != null) {
                frame.setContentPane(app.mainPanel);
            }
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

    private void createUIComponents() {

        mainPanel = new BackgroundPanel("background.jpg");


    }

    static class RoundedTextField extends JTextField {
        private int cornerRadius = 25;
        private Color backgroundColor = new Color(255, 255, 255, 180);

        public RoundedTextField() {
            setOpaque(false);
            setBackground(backgroundColor);
            setForeground(Color.BLACK);
            setCaretColor(Color.BLACK);
            setFont(new Font("Tahoma", Font.PLAIN, 18));
            setColumns(20);
            setBorder(new EmptyBorder(10, 20, 10, 20));
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(getBackground());
            g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, cornerRadius, cornerRadius);
            g2.dispose();
            super.paintComponent(g);
        }
    }

    static class BackgroundPanel extends JPanel {
        private Image backgroundImage;
        private final String fileName;

        public BackgroundPanel(String fileName) {
            this.fileName = fileName;
            try {
                URL imgUrl = Main.class.getResource("/" + fileName);
                if (imgUrl != null) {
                    backgroundImage = ImageIO.read(imgUrl);
                } else {
                    File imageFile = new File("src", fileName);
                    if (imageFile.exists()) {
                        backgroundImage = ImageIO.read(imageFile);
                    } else {
                        System.err.println("Could not find background image: " + fileName);
                    }
                }
                if (backgroundImage == null && looksLikeWebP(fileName)) {
                    System.err.println("Background file is WEBP data with the wrong extension. Convert it to PNG or JPG first: " + fileName);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            setOpaque(false);
            setLayout(new BorderLayout());
        }

        private boolean looksLikeWebP(String fileName) {
            try (InputStream input = Main.class.getResourceAsStream("/" + fileName)) {
                if (input != null) {
                    byte[] header = input.readNBytes(12);
                    return isWebPHeader(header);
                }
            } catch (IOException ignored) {
            }

            File imageFile = new File("src", fileName);
            if (imageFile.exists()) {
                try (InputStream input = java.nio.file.Files.newInputStream(imageFile.toPath())) {
                    byte[] header = input.readNBytes(12);
                    return isWebPHeader(header);
                } catch (IOException ignored) {
                }
            }

            return false;
        }

        private boolean isWebPHeader(byte[] header) {
            return header.length >= 12
                    && header[0] == 'R'
                    && header[1] == 'I'
                    && header[2] == 'F'
                    && header[3] == 'F'
                    && header[8] == 'W'
                    && header[9] == 'E'
                    && header[10] == 'B'
                    && header[11] == 'P';
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (backgroundImage != null) {
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            } else {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                GradientPaint gradient = new GradientPaint(
                        0, 0, new Color(252, 244, 221),
                        getWidth(), getHeight(), new Color(227, 239, 255)
                );
                g2.setPaint(gradient);
                g2.fillRect(0, 0, getWidth(), getHeight());
                g2.dispose();
            }
        }
    }
}
