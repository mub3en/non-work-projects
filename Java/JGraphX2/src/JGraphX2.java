import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.SwingConstants;

import com.mxgraph.layout.mxCompactTreeLayout;
import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
import com.mxgraph.model.mxGeometry;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxConstants;
import com.mxgraph.util.mxPoint;
import com.mxgraph.util.mxRectangle;
import com.mxgraph.view.mxGraph;
import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
public class JGraphX2 extends JFrame
{

    private static final long serialVersionUID = -2707712944901661771L;
//    SimpleTreeNode<String> root = createSimpleTreeNode();
    SimpleTreeNode<String> govt = createSimpleTreeNode();

    public void fillGraphFromModel( mxGraph graph)  {
        //   graphUpdate();

        Object parent = graph.getDefaultParent();

        graph.getModel().beginUpdate();

        try
        {
            Object vRoot = graph.insertVertex(parent, null, createSimpleTreeNode().getData(), 100, 00, 120, 40);

            CreateGraphPoints(graph, parent, vRoot, createSimpleTreeNode());
            mxHierarchicalLayout layout = new mxHierarchicalLayout(graph);
            layout.setUseBoundingBox(false);
            layout.execute(parent);
        }
        finally
        {
            graph.getModel().endUpdate();
        }

//        mxGraphComponent graphComponent = new mxGraphComponent(graph);
    }

    public void CreateGraphPoints(mxGraph graph, Object parent, Object vRoot, SimpleTreeNode<String> parentNode)
    {
        for(SimpleTreeNode child : parentNode.getChildren())
        {
            Object meRoot = graph.insertVertex(parent, null, child.getData(), 100, 0, 100, 45);
            graph.insertEdge(parent, null, "", vRoot, meRoot);


            if(child.childCount() > 0)
            {
                // Recursively draw nodes
                CreateGraphPoints(graph, parent, meRoot, child);
            }
        }
    }


    public JGraphX2()
    {
        super("Simple Tree Node");
        mxGraph graph = new mxGraph();
        fillGraphFromModel(graph);
        mxGraphComponent graphComponent = new mxGraphComponent(graph);
        getContentPane().add(graphComponent);


    }
    
    public SimpleTreeNode<String> createSimpleTreeNode() {
        govt = new SimpleTreeNode<>("Government Branches");  
        
        //Legislative
        SimpleTreeNode<String> legislative = new SimpleTreeNode<>("Legislative");
        SimpleTreeNode<String> congress = new SimpleTreeNode<>("Congress");
        SimpleTreeNode<String> houseRps = new SimpleTreeNode<>("House of \nRepresentatives");
        SimpleTreeNode<String> senate = new SimpleTreeNode<>("Senate");
        legislative.addChild(congress);
        congress.addChild(houseRps);
        houseRps.addChild("435 Total");
        congress.addChild(senate);
        senate.addChild("100 Total");
        
        //Executive
        SimpleTreeNode<String> executive = new SimpleTreeNode<>("Executive");
        SimpleTreeNode<String> president = new SimpleTreeNode<>("President");
        SimpleTreeNode<String> cabinet = new SimpleTreeNode<>("Cabinet");
        SimpleTreeNode<String> dod = new SimpleTreeNode<>("Department of \nDefense");
        executive.addChild(president);
        president.addChild("Vice President");
        president.addChild(cabinet);
        cabinet.addChild("Department of \nDefense");
        cabinet.addChild(dod);
        dod.addChild("Department of \nthe Army");
        dod.addChild("Department of \nthe Navy");
        dod.addChild("Department of \nthe Air Force");
        dod.addChild("Joint chiefs of \n staff");
        cabinet.addChild("Department of \nState");    
        
        //Judicial
        SimpleTreeNode<String> judicial = new SimpleTreeNode<>("Judicial");
        SimpleTreeNode<String> supremeCourt = new SimpleTreeNode<>("Supreme Court");
        SimpleTreeNode<String> armedForcesCourt = new SimpleTreeNode<>("US Courts of \nAppeals for the \nArmed Forces");
        SimpleTreeNode<String> armedForcesnCrminalAppealsCourt = new SimpleTreeNode<>("Courts of \nCrminal Appeals.");
        judicial.addChild(supremeCourt);
        supremeCourt.addChild("US Courts of \nAppeals");
        supremeCourt.addChild("US Courts of \nAppeals for the \nFederal Circuit");
        supremeCourt.addChild(armedForcesCourt);
        armedForcesCourt.addChild(armedForcesnCrminalAppealsCourt);
        armedForcesnCrminalAppealsCourt.addChild("Court Martail");
        
        

        //Adding all sub branches and first children to the root branch
        govt.addChildren(Arrays.asList(legislative, executive, judicial));
        
        for (SimpleTreeNode child: govt.getChildren()) {
        	govt.printChildren(child);
        }
        return govt;
    }

    public static void main(String[] args)
    {
        JGraphX2 frame = new JGraphX2();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 650);
        frame.setVisible(true);
    }

}