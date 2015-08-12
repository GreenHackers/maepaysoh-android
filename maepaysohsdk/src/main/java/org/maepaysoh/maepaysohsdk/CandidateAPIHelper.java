package org.maepaysoh.maepaysohsdk;

import java.util.HashMap;
import java.util.Map;
import org.maepaysoh.maepaysohsdk.api.CandidateService;
import org.maepaysoh.maepaysohsdk.api.RetrofitHelper;
import org.maepaysoh.maepaysohsdk.models.CandidateReturnObject;
import retrofit.Callback;
import retrofit.RestAdapter;

/**
 * Created by yemyatthu on 8/11/15.
 */
public class CandidateAPIHelper{
  private RestAdapter mCandidateRestAdapter;
  private CandidateService mCandidateService;
  public CandidateAPIHelper(String token){
    mCandidateRestAdapter = RetrofitHelper.getResAdapter(token);
    mCandidateService = mCandidateRestAdapter.create(CandidateService.class);
  }

  /**
   *
   * @param callback
   */
  public void getCandidates(Callback<CandidateReturnObject> callback){
    getCandidates(false,true,1,15,callback);
  }

  /**
   *
   * @param withParty
   * @param callback
   */
  public void getCandidates(boolean withParty,Callback<CandidateReturnObject> callback){
    getCandidates(withParty,true,1,15,callback);
  }


  /**
   *
   * @param withParty
   * @param unicode
   * @param callback
   */
  public void getCandidates(Boolean withParty,boolean unicode,Callback<CandidateReturnObject> callback){
    getCandidates(withParty,unicode,1,15,callback);
  }

  /**
   *
   * @param withParty
   * @param unicode
   * @param firstPage
   * @param callback
   */
  public void getCandidates(Boolean withParty,boolean unicode,int firstPage,Callback<CandidateReturnObject> callback){
    getCandidates(withParty, unicode, firstPage, 15, callback);
  }

  /**
   *
   * @param withParty
   * @param unicode
   * @param firstPage
   * @param perPage
   * @param callback
   */
  public void getCandidates(boolean withParty,boolean unicode,int firstPage,int perPage,Callback<CandidateReturnObject> callback){
    Map<CandidateService.PARAM_FIELD,String> optionParams = new HashMap<>();
    if(withParty) {
      optionParams.put(CandidateService.PARAM_FIELD._with, Constants.WITH_PARTY);
    }
    if(unicode) {
      optionParams.put(CandidateService.PARAM_FIELD.font, Constants.UNICODE);
    }else{
      optionParams.put(CandidateService.PARAM_FIELD.font, Constants.ZAWGYI);
    }
    optionParams.put(CandidateService.PARAM_FIELD.page,String.valueOf(firstPage));
    optionParams.put(CandidateService.PARAM_FIELD.per_page,String.valueOf(perPage));
    mCandidateService.listCandidates(optionParams, callback);
  }

  /**
   *
   * @param candidateId
   * @param callback
   */
  public void getCandidateById(String candidateId,Callback<CandidateReturnObject> callback){
    getCandidateById(candidateId,true,true,callback);
  }

  /**
   *
   * @param candidateId
   * @param withParty
   * @param callback
   */
  public void getCandidateById(String candidateId,boolean withParty,Callback<CandidateReturnObject> callback){
    getCandidateById(candidateId,withParty,true,callback);
  }

  /**
   *
   * @param candidateId
   * @param withParty
   * @param unicode
   * @param callback
   */
  public void getCandidateById(String candidateId,Boolean withParty,boolean unicode,Callback<CandidateReturnObject> callback){
    Map<CandidateService.PARAM_FIELD,String> optionParams = new HashMap<>();
    if(withParty) {
      optionParams.put(CandidateService.PARAM_FIELD._with, Constants.WITH_PARTY);
    }
    if(unicode) {
      optionParams.put(CandidateService.PARAM_FIELD.font, Constants.UNICODE);
    }else{
      optionParams.put(CandidateService.PARAM_FIELD.font, Constants.ZAWGYI);
    }
    mCandidateService.getCandidateById(candidateId,optionParams,callback);
  }

}
