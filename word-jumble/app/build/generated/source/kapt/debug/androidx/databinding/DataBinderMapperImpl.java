package androidx.databinding;

public class DataBinderMapperImpl extends MergedDataBinderMapper {
  DataBinderMapperImpl() {
    addMapper(new myapp.swati.wordjumble.DataBinderMapperImpl());
  }
}
