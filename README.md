

## FEATURE ##
- adapter for RecyclerView & AdapterView


- height WRAP-CONTENT for RecyclerView(LinearLayout & GirdLayout)


- CommonItemDecoration for RecyclerView


![image](https://github.com/vihuela/RecyclerViewHelpper/blob/master/example.gif ) 

----------


> RecyclerView **SingleItem** 单个条目




- adapter

		    public class FuelAdapter extends RecyclerViewAdapter<FuelBean> {
		    public FuelAdapter(RecyclerView recyclerView, List<FuelBean> list) {
		        super(recyclerView, R.layout.item2, list);
		    }
		
		    @Override protected void setItemChildListener(ViewHolderHelper viewHolderHelper) {
		        super.setItemChildListener(viewHolderHelper);
		        viewHolderHelper.setItemChildClickListener(R.id.faveVal);
		        viewHolderHelper.setItemChildClickListener(R.id.priceLayout);
		        viewHolderHelper.setItemChildClickListener(R.id.labelView);
		    }
		
		    @Override protected void fillData(ViewHolderHelper viewHolderHelper, int position, FuelBean model) {
		        LabelView_New labelViewNew = viewHolderHelper.getView(R.id.labelView);
		        labelViewNew.setText(model.discount + "折");
		        viewHolderHelper.setText(R.id.faveVal, model.faceVal + "");
		        viewHolderHelper.setText(R.id.price, model.price + "");
		        viewHolderHelper.getView(R.id.mainContent).setSelected(model.isSelect);
		    }
		}



- activity

		rv.setLayoutManager(new WRGridLayoutManager(this, 2));
        final FuelAdapter fuelAdapter = new FuelAdapter(rv, DataEngine.S_MOCK4);
        /**
         * item点击
         */
        fuelAdapter.setOnRVItemClickListener(new OnRVItemClickListener() {
            @Override public void onRVItemClick(ViewGroup parent, View itemView, int position) {
                fuelAdapter.setSelectItem(position, null);
            }
        });
        /**
         * item子条目点击
         */
        fuelAdapter.setOnItemChildClickListener(new OnItemChildClickListener() {
            @Override public void onItemChildClick(ViewGroup parent, View childView, int position) {
                FuelBean item = fuelAdapter.getItem(position);
                switch (childView.getId()) {
                    case R.id.faveVal:
                        Toast.makeText(parent.getContext(), item.faceVal + "", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.priceLayout:
                        Toast.makeText(parent.getContext(), item.price + "", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.labelView:
                        Toast.makeText(parent.getContext(), item.discount + "", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
        rv.addItemDecoration(new GridItemDecoration(2, DensityUtils.dip2px(this, 14f), true));
        rv.setAdapter(fuelAdapter);


> RecyclerView **MultiItem** 多个条目

- adapter


	    public class MultiAdapter extends RecyclerViewAdapter<Object> {
	    public final static int TYPE_1 = 1;
	    public final static int TYPE_2 = 2;
	
	    public MultiAdapter(RecyclerView recyclerView) {
	        super(recyclerView, R.layout.item2);
	    }
	
	    @Override protected int getItemViewResId(int viewType) {
	        switch (viewType) {
	            case TYPE_1:
	                return R.layout.item1;
	            case TYPE_2:
	                return R.layout.item2;
	        }
	        return super.getItemViewResId(viewType);
	    }
	
	    @Override public int getItemViewType(int position) {
	
	        return (getItem(position) instanceof String) ? TYPE_1 : TYPE_2;
	    }
	
	    @Override protected void fillData(ViewHolderHelper viewHolderHelper, int position, Object model) {
	        switch (getItemViewType(position)) {
	            case TYPE_1:
	                String s = (String) model;
	                viewHolderHelper.setText(R.id.tv, s);
	                break;
	            case TYPE_2:
	                FuelBean fuelBean = (FuelBean) model;
	                LabelView_New labelViewNew = viewHolderHelper.getView(R.id.labelView);
	                labelViewNew.setText(fuelBean.discount + "折");
	                viewHolderHelper.setText(R.id.faveVal, fuelBean.faceVal + "");
	                viewHolderHelper.setText(R.id.price, fuelBean.price + "");
	                viewHolderHelper.getView(R.id.mainContent).setSelected(fuelBean.isSelect);
	                break;
	        }
	
	    }
	   
	  }

- activity

	//

> ListView or GirdView

    ListView lv = (ListView) findViewById(R.id.lv);
        final AdapterViewAdapter<String> adapter = new AdapterViewAdapter<String>(this, R.layout.item1, DataEngine.S_MOCK1) {

            @Override protected void fillData(ViewHolderHelper viewHolderHelper, int position, String model) {
                viewHolderHelper.setText(R.id.tv, model);
            }

            @Override protected void setItemChildListener(ViewHolderHelper viewHolderHelper) {
                viewHolderHelper.setItemChildClickListener(R.id.rootView);
            }
        };
        adapter.setOnItemChildClickListener(new OnItemChildClickListener() {
            @Override public void onItemChildClick(ViewGroup parent, View childView, int position) {
                if (childView.getId() == R.id.rootView)
                    Toast.makeText(parent.getContext(), adapter.getItem(position), Toast.LENGTH_SHORT).show();
            }
        });
        lv.setAdapter(adapter);


    

##CHECK DEMO FOR DETAIL


## GRADLE ##

compile 'com.hadlink:rvhelpperlib:1.0.2'


