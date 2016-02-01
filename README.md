

## FEATURE ##
- adapter for RecyclerView & AdapterView
	


	1. item \ subItem click\longClick
 

	2. MUL item simple useage


- height WRAP-CONTENT for RecyclerView(LinearLayout & GirdLayout)


- CommonItemDecoration for RecyclerView







> code


		    List<String> strings = new ArrayList<>();
		        Collections.addAll(strings, "aaaaaaaaa", "bbbbbbbbbbbb", "ccccccccccc");
		        rv.addItemDecoration(new CommonItemDecoration(14));
		        rv.setLayoutManager(new WRLinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
		        rv.setAdapter(new RecyclerViewAdapter<String>(rv, R.layout.item1, strings) {
		
		            @Override protected void fillData(ViewHolderHelper viewHolderHelper, int position, String model) {
		                viewHolderHelper.setText(R.id.tv, model);
		            }
		        });

![](http://i.imgur.com/sJTQArp.png)
    

CHECK DEMO FOR DETAIL


## GRADLE ##

compile 'com.hadlink:rvhelpperlib:latestVersion@aar'
