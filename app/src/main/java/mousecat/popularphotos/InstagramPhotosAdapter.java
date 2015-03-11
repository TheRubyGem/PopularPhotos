package mousecat.popularphotos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by cdolnick on 1/2/15.
 */
public class InstagramPhotosAdapter extends ArrayAdapter<InstagramPhoto> {
    public InstagramPhotosAdapter(Context context, List<InstagramPhoto> photos) {
        super(context, R.layout.item_photo, photos);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        InstagramPhoto photo = getItem(position);
        if (convertView == null) {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_photo, parent, false);
        }
        TextView tvCaption = (TextView) convertView.findViewById(R.id.tvCaption);
        ImageView imgPhoto = (ImageView) convertView.findViewById(R.id.imgPhoto);
        TextView tvLikes = (TextView) convertView.findViewById(R.id.tvLikes);
        TextView tvUserName = (TextView) convertView.findViewById(R.id.tvUserName);
        ImageView imgProfile = (ImageView) convertView.findViewById(R.id.imgProfile);
        tvCaption.setText(photo.caption);
        tvLikes.setText(Integer.toString(photo.likesCount));
        tvUserName.setText(photo.username);
        imgPhoto.getLayoutParams().height = photo.imageHeight;
        imgPhoto.setImageResource(0);
        Picasso.with(getContext()).load(photo.imageUrl).into(imgPhoto);
        imgProfile.setImageResource(0);
        Picasso.with(getContext()).load(photo.profileUrl).into(imgProfile);
        return convertView;
    }
}
