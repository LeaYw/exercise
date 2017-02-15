package com.lyw.exercise;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;

import com.lyw.exercise.model.Address;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class AddressActivity extends AppCompatActivity {
	private static final String TAG = "AddressActivity";
	private TextView province;
	private TextView city;
	private TextView town;
	private List<Address> listProvince;
	private List<Address> listCity;
	private List<Address> listTown;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_address);
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		listProvince = getData(Address.FILE_PROVINCE, 0);
		for (Address address : listProvince) {
			Log.e(TAG, address.getName());
		}
		listCity = getCities(5);
		for (Address address : listCity) {
			Log.e(TAG, address.getName());
		}
		listTown = getTowns(99);
		for (Address address : listTown) {
			Log.e(TAG, address.getName());
		}
	}

	private List<Address> getProvinces() {
		return getData(Address.FILE_PROVINCE, 0);
	}

	private List<Address> getCities(int provinceId) {
		return getData(Address.FILE_CITY, provinceId);
	}

	private List<Address> getTowns(int cityId) {
		return getData(Address.FILE_TOWN, cityId);
	}

	/**
	 * @param fileName 读取的文件名
	 * @param parentId 父级地区的id，如果获取省级数据，直接传0;
	 * @return 属于父级的所有下一级地区
	 */
	private List<Address> getData(String fileName, int parentId) {
		List<Address> addresses = new ArrayList<>();
		InputStream provinceInputStream = null;
		try {
			provinceInputStream = getAssets().open(fileName);
			XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
			factory.setNamespaceAware(true);
			XmlPullParser parser = factory.newPullParser();
			parser.setInput(provinceInputStream, "UTF-8");

			int eventType = parser.getEventType();
			while (eventType != XmlPullParser.END_DOCUMENT) {
				switch (eventType) {
					case XmlPullParser.START_DOCUMENT:
						break;
					case XmlPullParser.START_TAG:
						if (parser.getName().equals(Address.LABEL_NAME)) {
							if (parentId == 0) {
								Address address = new Address();
								address.setId(Integer.valueOf(parser.getAttributeValue(Address.POSITION_ID)));
								address.setName(parser.getAttributeValue(Address.POSITION_NAME));
								addresses.add(address);
							} else {
								int pId = Integer.valueOf(parser.getAttributeValue(Address.POSITION_PID));
								if (pId == parentId) {
									Address address = new Address();
									address.setId(Integer.valueOf(parser.getAttributeValue(Address.POSITION_ID)));
									address.setName(parser.getAttributeValue(Address.POSITION_NAME));
									address.setpId(pId);
									addresses.add(address);
								}
							}
						}
						break;
					case XmlPullParser.END_TAG:
						break;
				}
				eventType = parser.next();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (XmlPullParserException e) {
			e.printStackTrace();
		} finally {
			try {
				if (provinceInputStream != null) {
					provinceInputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return addresses;
	}

}
